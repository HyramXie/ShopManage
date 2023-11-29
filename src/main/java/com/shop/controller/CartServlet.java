package com.shop.controller;

import java.io.IOException;
import java.lang.reflect.Method;
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
import com.shop.service.CartService;



@WebServlet(urlPatterns={"/CartServlet", "/AddCartItem", "/SearchCartItem", "/ShopCart"})
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void AddCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int stock = Integer.parseInt(request.getParameter("stock"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if (quantity > stock) {
			String name = request.getParameter("name");
			String category = request.getParameter("categoryid");
			double price = Double.parseDouble(request.getParameter("price"));
			Product product = new Product(id, name, price, quantity, category);
 			request.setAttribute("result", true);
 			request.setAttribute("product", product);
			request.getRequestDispatcher("/AddCartItem.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			CartItem cartItem = new CartItem(user.getUserID(), id, quantity);
			if (service.checkCartItem(id) != null) 
				service.updateCartItem(cartItem);
			else
				service.addCartItem(cartItem);
			response.sendRedirect(request.getContextPath()+"/Product.jsp");
		}
	}
	
	public void ShopCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartService service = new CartService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<CartItem>	cartItems= service.getCartItemList(user.getUserID());
		request.setAttribute("cartItems", cartItems);
		request.getRequestDispatcher("/ShopCart.jsp").forward(request, response);;
	}

}
