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

import com.shop.bean.Category;
import com.shop.bean.Order;
import com.shop.bean.OrderItem;
import com.shop.bean.Product;
import com.shop.bean.User;
import com.shop.service.CategoryService;
import com.shop.service.OrderItemService;
import com.shop.service.OrderService;
import com.shop.service.ProductService;

@WebServlet(urlPatterns={"/Product", "/GetSelect", "/AddProduct", "/ModifyProduct", "/DeleteProduct", "/UpdateProduct", "/ChangeStatus", "/BuyProduct"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductServlet() {
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
	
	public void GetSelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryList(request, response);
		response.sendRedirect(request.getContextPath()+"/AddProduct.jsp");
	}
	
	public void AddProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductService();
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int categoryId = Integer.parseInt(request.getParameter("categoryid"));

		Product product = new Product(name, price, stock, categoryId);
		if (service.checkProduct(product) == null) {
			service.addProduct(product);
			GetProduct(request, response);
		}
		response.sendRedirect(request.getContextPath()+"/AddProduct.jsp");

	}
	
	public void Product(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryList(request, response);
		HttpSession session = request.getSession();
		if (session.getAttribute("products") == null) {
			GetProduct(request, response);
		}
		if(request.getParameter("shop") != null)
			response.sendRedirect(request.getContextPath()+"/Product.jsp");
		else
			response.sendRedirect(request.getContextPath()+"/ModifyProduct.jsp");
	}
	
	public void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductService();
		int id = Integer.parseInt(request.getParameter("id"));
		service.deleteProduct(id);
		GetProduct(request, response);
		response.sendRedirect(request.getContextPath()+"/ModifyProduct.jsp");
	}
	
	public void UpdateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductService();
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		double price = Double.parseDouble(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int categoryid = Integer.parseInt(request.getParameter("categoryid"));
		
		Product product = new Product(id, name, price, stock, categoryid);
		service.updateProduct(product);
		GetProduct(request, response);
		response.sendRedirect(request.getContextPath()+"/ModifyProduct.jsp");
	}
	
	public void ChangeStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductService();
		int id = Integer.parseInt(request.getParameter("id"));
		service.updateProduct(id);
		GetProduct(request, response);
		response.sendRedirect(request.getContextPath()+"/ModifyProduct.jsp");
	}
	
	
	
	//这里进行统一判断
	public void CategoryList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		if (session.getAttribute("categories") == null) {
			CategoryService service = new CategoryService();
			List<Category> categories = service.getCategoryList();
			session.setAttribute("categories", categories);
		}
	}
	//shop管理
	public void GetProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ProductService service = new ProductService();
		List<Product> products = service.getProductList();
		session.setAttribute("products", products);
	}
	
	public void BuyProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderService orderService = new OrderService();
		ProductService productService = new ProductService();
		OrderItemService orderItemService = new OrderItemService();
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = productService.checkProduct(id);
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if (quantity > product.getStockQuantity()) {
 			request.setAttribute("result", true);
			request.getRequestDispatcher("/BuyProduct.jsp").forward(request, response);
		}
		else {
			HttpSession session =request.getSession();
			int userid = ((User)session.getAttribute("user")).getUserID();
			String address = ((User)session.getAttribute("user")).getAddress();
			double price = product.getPrice()*quantity;
			Order order = new Order(userid, (new Date()).toString(), 0, price, address);
			Object object = orderService.addOrder(order);
			int orderID = Integer.parseInt(object.toString());
			OrderItem orderItem = new OrderItem(orderID, id, quantity);
			orderItemService.addOrderItem(orderItem);
			productService.updateProduct(id, quantity);
			GetProduct(request, response);
			response.sendRedirect(request.getContextPath()+"/OrderDetail?id="+orderID);
		}
	}

	
}
