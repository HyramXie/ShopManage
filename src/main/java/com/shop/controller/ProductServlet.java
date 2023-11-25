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

import com.shop.bean.Product;
import com.shop.bean.Category;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;

@WebServlet(urlPatterns={"/ProductServlet", "/GetCategory", "/AddProduct"})
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
	
	public void GetCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryService service = new CategoryService();
		List<Category> categories = service.getCategoryList();
		HttpSession session = request.getSession();
		session.setAttribute("categories", categories);
		response.sendRedirect(request.getContextPath()+"/AddProduct.jsp");
	}
	
	public void AddProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductService();
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		String stockStr = request.getParameter("stock");
		String categoryIdStr = request.getParameter("categoryid");
		
		double price = 0.0;
		int stock = 0;
		int categoryId = 0;
		if (priceStr != null && !priceStr.isEmpty()) 
		    price = Double.parseDouble(priceStr);
		if (stockStr != null && !stockStr.isEmpty()) 
		    stock = Integer.parseInt(stockStr);
		if (categoryIdStr != null && !categoryIdStr.isEmpty())
		    categoryId = Integer.parseInt(categoryIdStr);
		
		Product product = new Product(name, price, stock, categoryId);
		if (!service.checkCategory(product)) {
			service.addCategory(product);
		}
		response.sendRedirect(request.getContextPath()+"/AddProduct.jsp");

	}
}
