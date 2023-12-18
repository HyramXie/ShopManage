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

import com.shop.bean.Category;
import com.shop.service.CategoryService;



@WebServlet(urlPatterns={"/CategoryServlet", "/AddCategory", "/ModifyCategory", "/DeleteCategory", "/UpdateCategory"})
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CategoryServlet() {
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
		GetCategory(request, response);
		response.sendRedirect(request.getContextPath()+"/AddCategory.jsp");

	}
	
	public void ModifyCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GetCategory(request, response);
		response.sendRedirect(request.getContextPath()+"/ModifyCategory.jsp");
	}
	
	public void DeleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryService service = new CategoryService();
		int id = Integer.parseInt(request.getParameter("id"));
		service.deleteCategory(id);
		GetCategory(request, response);
		response.sendRedirect(request.getContextPath()+"/ModifyCategory.jsp");
	}
	
	public void UpdateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CategoryService service = new CategoryService();
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = new Category(id, name);
		service.updateCategory(category);
		GetCategory(request, response);
		response.sendRedirect(request.getContextPath()+"/ModifyCategory.jsp");
	}
	
	public void GetCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		CategoryService service = new CategoryService();
		List<Category> categories = service.getCategoryList();
		session.setAttribute("categories", categories);
	}
}
