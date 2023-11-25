package com.shop.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.bean.Category;
import com.shop.service.CategoryService;



@WebServlet(urlPatterns={"/CategoryServlet", "/AddCategory"})
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CategoryServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String methodName =  servletPath.substring(1, servletPath.length());
		System.out.println(methodName);
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
	
	public void AddCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryService service = new CategoryService();
		String name = request.getParameter("name");
		Category category = new Category(name);
		if (!service.checkCategory(category)) {
			service.addCategory(category);
		}
		response.sendRedirect(request.getContextPath()+"/AddCategory.jsp");

	}
	

}
