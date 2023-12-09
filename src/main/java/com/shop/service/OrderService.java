package com.shop.service;

import java.sql.Connection;
import java.util.List;

import com.shop.bean.Order;
import com.shop.dao.OrderDao;
import com.shop.daoImpl.OrderDaoJdbcImpl;
import com.shop.utils.JdbcTools;

public class OrderService {
	private OrderDao dao;
	
	public OrderService() {
		this.dao = new OrderDaoJdbcImpl();
	}
	
	
	
	public Order checkOrder(int orderID){
		Connection connection = null;
		Order result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.searchOrder(connection, orderID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public Object addOrder(Order order){
		Connection connection = null;
		Object result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.addOrder(connection, order);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public List<Order> getOrderList(int id){
		Connection connection = null;
		List<Order> orders = null;
		try {
			connection = JdbcTools.getConnection();
			orders = dao.fetchAllOrder(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return orders;
	}
	
	public List<Order> getOrderList(){
		Connection connection = null;
		List<Order> orders = null;
		try {
			connection = JdbcTools.getConnection();
			orders = dao.fetchAllOrder(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return orders;
	}
	
	public void deleteOrder(int id){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.deleteOrder(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	
	public void updateOrder(int orderID, int status){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateOrder(connection, orderID, status);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public void updateOrder(int orderID, int status, String address){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateOrder(connection, orderID, status, address);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
}
