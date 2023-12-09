package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.bean.Order;
import com.shop.bean.OrderItem;
import com.shop.bean.User;
import com.shop.service.OrderItemService;
import com.shop.service.OrderService;

@WebServlet(urlPatterns={"/OrderServlet", "/MyOrder", "/OrderDetail", "/ChangeOrderStatus", "/DeleteOrder", "/OrderDeal", "/ManageChangeOrder"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderServlet() {
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
		doGet(request, response);
	}
	
	public void MyOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderService service = new OrderService();
		OrderItemService orderItemService = new OrderItemService();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Order>	orders= service.getOrderList(user.getUserID());
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(Order order : orders) {
			orderItems.addAll(orderItemService.getOrderItemList(order.getOrderID())) ;
		}
		request.setAttribute("orders", orders);
		request.setAttribute("orderItems", orderItems);
		request.getRequestDispatcher("/MyOrder.jsp").forward(request, response);
	}
	
	public void OrderDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderService service = new OrderService();
		OrderItemService orderItemService = new OrderItemService();
		int id = Integer.parseInt(request.getParameter("id"));
		Order oneOrder = service.checkOrder(id);
		List<OrderItem> oneOrderItems = orderItemService.getOrderItemList(id);
		request.setAttribute("oneOrder", oneOrder);
		request.setAttribute("oneOrderItems", oneOrderItems);
		if (request.getParameter("manage") != null)
			request.getRequestDispatcher("/ManageOrderDetail.jsp").forward(request, response);
		else 
			request.getRequestDispatcher("/OrderDetail.jsp").forward(request, response);
	}
	
	public void ChangeOrderStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		OrderService service = new OrderService();
		int orderID = Integer.parseInt(request.getParameter("id")) ; 
		Order order = service.checkOrder(orderID);
		int status = order.getStatus();
		int changeStatus = status;
		if(status == 0 || status == -1) {
			changeStatus = 1;
		}else if(status > 0){
			changeStatus = -1;
		}else {}
		if (status == 0) {
			String address = request.getParameter("address");
			if (address == "") {
				out.print("<script> alert('地址不能为空'); </script>");
				out.print("<script> setTimeout(()=>{window.location.replace('http://localhost:8080/javawebshop/MyOrder')},10) </script>");
				return;
			}
			else
				service.updateOrder(orderID, changeStatus, address);
		}
		else 
			service.updateOrder(orderID, changeStatus);
		MyOrder(request, response);
	}
	
	public void DeleteOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		OrderService service = new OrderService();
		int orderID = Integer.parseInt(request.getParameter("id")) ; 
		Order order = service.checkOrder(orderID);
		int status = order.getStatus();
		if(status == 2 || status == -2 || status == 0) {
			service.deleteOrder(orderID);
			MyOrder(request, response);
		}else {
			out.print("<script> alert('暂时不能删除'); </script>");
			out.print("<script> setTimeout(()=>{window.location.replace('http://localhost:8080/javawebshop/MyOrder')},10) </script>");
		}
		
	}
	
	public void OrderDeal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderService service = new OrderService();
		OrderItemService orderItemService = new OrderItemService();
		List<Order>	orders= service.getOrderList();
		List<OrderItem> orderItems = orderItemService.getOrderItemList();
		request.setAttribute("orders", orders);
		request.setAttribute("orderItems", orderItems);
		request.getRequestDispatcher("/OrderDeal.jsp").forward(request, response);
	}
	
	public void ManageChangeOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderService service = new OrderService();
		int orderID = Integer.parseInt(request.getParameter("id")) ; 
		Order order = service.checkOrder(orderID);
		int status = order.getStatus();
		int changeStatus = status;
		if(status == 1) {
			changeStatus = 2;
		}else if(status == -1){
			changeStatus = -2;
		}else {}
		service.updateOrder(orderID, changeStatus);
		OrderDeal(request, response);
	}

}
