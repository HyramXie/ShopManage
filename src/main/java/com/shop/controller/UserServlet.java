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

import com.mysql.cj.Session;
import com.shop.bean.User;
import com.shop.service.UserService;


@WebServlet("*.user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		String methodName =  servletPath.substring(1, servletPath.length()-5);
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
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		UserService service = new UserService();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(name, password);
		User result = service.checkUser(user);
		if (result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", result);
			response.sendRedirect(request.getContextPath()+"/home.jsp");
		}
		else {
			out.print("<script> alert('登录失败，用户名不存在！请先注册！'); </script>");
		}
	}
	
	public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		UserService service = new UserService();
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		User user = new User(name, password, email, phone);
		User result = service.checkUser(user);
		if (result != null) {
			service.registUser(user);
			response.sendRedirect(request.getContextPath()+"/userlogin.jsp");
		}
		else {
			out.print("<script> alert('用户已存在'); </script>");
			response.sendRedirect(request.getContextPath()+"/register.jsp");
		}
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserService service = new UserService();
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		User user1 = (User)session.getAttribute("user");
 		User user = new User(name, password, email, phone);
 		user.setUserID(user1.getUserID());
 		System.out.println(user1.getUserID());
 		service.changeUser(user);
 		session.setAttribute("user", user);
 		response.sendRedirect(request.getContextPath()+"/home.jsp");
	}
}
