package com.shop.controller;

import java.io.IOException;
import java.lang.reflect.Method;
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
	
	public void AddCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		int id = Integer.parseInt(request.getParameter("id"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if (quantity > stock) {
 			request.setAttribute("result", true);
			request.getRequestDispatcher("/AddCartItem.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			CartItem temp = service.checkCartItem(user.getUserID(), id);
			if (temp != null) {
				CartItem cartItem = new CartItem(temp.getCartItemID(), quantity);
				service.updateCartItem(cartItem);
			}
				
			else {
				CartItem cartItem = new CartItem(user.getUserID(), id, quantity);
				service.addCartItem(cartItem);
			}
			response.sendRedirect(request.getContextPath()+"/Product.jsp");
		}
	}
	
	public void ShopCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<CartItem>	cartItems= service.getCartItemList(user.getUserID());
		request.setAttribute("cartItems", cartItems);
		request.getRequestDispatcher("/ShopCart.jsp").forward(request, response);
	}
	
	public void UpdateCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//库存不足
		ProductService productService = new ProductService();
		CartService service = new CartService();
		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String name = request.getParameter("name");
		Product product = new Product(name);
		Product result = productService.checkProduct(product);
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
	
	public void DeleteCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		int id = Integer.parseInt(request.getParameter("id"));
		CartItem cartItem = new CartItem();
		cartItem.setCartItemID(id);
		service.deleteCartItem(id);
		ShopCart(request, response);
	}
	
	public void Submit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		ProductService productService = new ProductService();
		OrderService orderService = new OrderService();
		OrderItemService orderItemService = new OrderItemService();
		HttpSession session =request.getSession();
		String[] ids = request.getParameterValues("id");
		String[] pids = request.getParameterValues("pid");
		String[] quantitys = request.getParameterValues("quantity");
		String[] sum = request.getParameterValues("sum");
		//订单添加
		double price = 0;
		for (int i = 0; i < ids.length; i++) {
			price = Double.parseDouble(sum[i]);
		}
		int userid = ((User)session.getAttribute("user")).getUserID();
		String address = ((User)session.getAttribute("user")).getAddress();
		Order order = new Order(userid, (new Date()).toString(), 0, price, address);
		Object object = orderService.addOrder(order);
		int orderID = Integer.parseInt(object.toString());
		for (int i = 0; i < ids.length; i++) {
			int id = Integer.parseInt(ids[i]);
			int pid = Integer.parseInt(pids[i]);
			int quantity = Integer.parseInt(quantitys[i]);
			//insert
			OrderItem orderItem = new OrderItem(orderID, pid, quantity);
			orderItemService.addOrderItem(orderItem);
			
			//delete
			service.deleteCartItem(id);
			
			//update
			productService.updateProduct(pid, quantity);
			List<Product> products = productService.getProductList();
			session.setAttribute("products", products);
	    }
		response.sendRedirect(request.getContextPath()+"/OrderDetail?id="+orderID);
	}

}
