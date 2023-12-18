package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.bean.CartItem;
import com.shop.bean.Product;
import com.shop.bean.User;
import com.shop.bean.Order;
import com.shop.bean.OrderItem;
import com.shop.service.CartService;
import com.shop.service.OrderItemService;
import com.shop.service.OrderService;
import com.shop.service.ProductService;



@WebServlet(urlPatterns={"/CartServlet", "/AddCartItem", "/Submit", "/ShopCart", "/UpdateCartItem", "/DeleteCartItem"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String servletPath = request.getServletPath();
		String methodName =  servletPath.substring(1, servletPath.length());
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//添加到购物车功能
	public void AddCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		int id = Integer.parseInt(request.getParameter("id"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		//判断库存是否充足
		if (quantity > stock) {
 			request.setAttribute("result", true);
			request.getRequestDispatcher("/AddCartItem.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			CartItem temp = service.checkCartItem(id, user.getUserID());
			//判断产品是否已经存在于购物车，存在就更新
			if (temp != null) {
				CartItem cartItem = new CartItem(temp.getCartItemID(), quantity);
				service.updateCartItem(cartItem);
			}
			//不存在就添加	
			else {
				CartItem cartItem = new CartItem(user.getUserID(), id, quantity);
				service.addCartItem(cartItem);
			}
			response.sendRedirect(request.getContextPath()+"/Product.jsp");
		}
	}
	
	//购物车查看
	public void ShopCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<CartItem>	cartItems= service.getCartItemList(user.getUserID());
		request.setAttribute("cartItems", cartItems);
		request.getRequestDispatcher("/ShopCart.jsp").forward(request, response);
	}
	
	//更新购物车的数量
	public void UpdateCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService productService = new ProductService();
		CartService service = new CartService();
		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		Product product = new Product(name);
		Product result = productService.checkProduct(product);
		//判断库存
		if (result.getStockQuantity() < quantity) {
			request.setAttribute("result", true);
			request.getRequestDispatcher("/UpdateCartItem.jsp").forward(request, response);
		}
		else {
			CartItem cartItem = new CartItem(id, quantity);
			service.updateCartItem(cartItem);
			ShopCart(request, response);
		}
		
	}
	
	//删除购物车的产品
	public void DeleteCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		int id = Integer.parseInt(request.getParameter("id"));
		CartItem cartItem = new CartItem();
		cartItem.setCartItemID(id);
		service.deleteCartItem(id);
		ShopCart(request, response);
	}
	
	//结算购物车的产品
	public void Submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		CartService service = new CartService();
		ProductService productService = new ProductService();
		OrderService orderService = new OrderService();
		OrderItemService orderItemService = new OrderItemService();
		HttpSession session =request.getSession();
		String[] ids = request.getParameterValues("id");
		String[] pids = request.getParameterValues("pid");
		String[] quantitys = request.getParameterValues("quantity");
		//订单添加
		double price = 0;
		for (int i = 0; i < ids.length; i++) {
			int pid = Integer.parseInt(pids[i]);
			Product product = productService.checkProduct(pid);
			//判断库存
			int quantity = Integer.parseInt(quantitys[i]);
			if (quantity > product.getStockQuantity()) {
				out.print("<script> alert('库存不足'); </script>");
				out.print("<script> setTimeout(()=>{window.location.replace('http://localhost:8080/javawebshop/ShopCart')},10) </script>");
				return ;
			}
			price = price + quantity*product.getPrice();
		}
		User user = (User)session.getAttribute("user");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Order order = new Order(user.getUserID(), dateFormat.format(new Date()), 0, price, user.getAddress(), user.getUsername(), user.getPhoneNumber());
		Object object = orderService.addOrder(order);
		int orderID = Integer.parseInt(object.toString());
		for (int i = 0; i < ids.length; i++) {
			int id = Integer.parseInt(ids[i]);
			int pid = Integer.parseInt(pids[i]);
			String productName =  productService.checkProduct(pid).getProductName();
			int quantity = Integer.parseInt(quantitys[i]);
			//insert
			OrderItem orderItem = new OrderItem(orderID, pid, productName, quantity);
			orderItemService.addOrderItem(orderItem);
			
			//delete
			service.deleteCartItem(id);
			
			//update
			productService.updateProduct(pid, -quantity);
	    }
		List<Product> products = productService.getProductList();
		session.setAttribute("products", products);
		response.sendRedirect(request.getContextPath()+"/OrderDetail?id="+orderID);
	}

}
