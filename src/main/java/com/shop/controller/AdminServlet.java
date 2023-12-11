package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.bean.Admin;
import com.shop.service.AdminService;


@WebServlet(urlPatterns={"/AdminLogin"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
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
	
	//管理员登陆
	public void AdminLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		AdminService service = new AdminService();
		String name = request.getParameter("adminname");
		String password = request.getParameter("password");
		Admin admin = new Admin(name, password);
		Admin result = service.checkAdmin(admin);
		//登录查询
		if (result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", result);
			response.sendRedirect(request.getContextPath()+"/Manage.jsp");
		}
		else {
			out.print("<script> alert('登录失败，用户名不存在！请先注册！'); </script>");
		}
	}

}
