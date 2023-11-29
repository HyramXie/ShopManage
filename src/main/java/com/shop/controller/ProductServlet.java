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

@WebServlet(urlPatterns={"/ProductServlet", "/GetSelect", "/AddProduct", "/GetProduct", "/DeleteProduct", "/SearchProduct", "/UpdateProduct", "/ChangeStatus"})
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
		if (service.checkProduct(product) == null) {
			service.addProduct(product);
		}
		response.sendRedirect(request.getContextPath()+"/AddProduct.jsp");

	}
	
	public void GetProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("products") == null || request.getParameter("change") != null) {
			ProductService service = new ProductService();
			List<Product> products = service.getProductList();
			session.setAttribute("products", products);
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
		response.sendRedirect(request.getContextPath()+"/GetProduct?change=1");
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
		response.sendRedirect(request.getContextPath()+"/GetProduct?change=1");
	}
	
	public void SearchProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryList(request, response);
		ProductService service = new ProductService();
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = service.checkProduct(id);
		product.setProductID(id);
		request.setAttribute("product", product);
		if (request.getParameter("buy") != null) 
			request.getRequestDispatcher("/AddCartItem.jsp").forward(request, response);
		else 	
			request.getRequestDispatcher("/UpdateProduct.jsp").forward(request, response);
	}
	
	public void CategoryList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		if (session.getAttribute("categories") == null) {
			CategoryService service = new CategoryService();
			List<Category> categories = service.getCategoryList();
			session.setAttribute("categories", categories);
		}
	}
	
	public void ChangeStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductService service = new ProductService();
		int id = Integer.parseInt(request.getParameter("id"));
		service.updateProduct(id);
		response.sendRedirect(request.getContextPath()+"/GetProduct?change=1");
	}
	
}
