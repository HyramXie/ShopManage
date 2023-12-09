package com.shop.service;

import java.sql.Connection;
import java.util.List;

import com.shop.bean.OrderItem;
import com.shop.dao.OrderItemDao;
import com.shop.daoImpl.OrderItemDaoJdbcImpl;
import com.shop.utils.JdbcTools;

public class OrderItemService {
private OrderItemDao dao;
	
	public OrderItemService() {
		this.dao = new OrderItemDaoJdbcImpl();
	}
	
	public OrderItem checkOrder(OrderItem orderItem){
//		Connection connection = null;
//		Order result = null;
//		try {
//			connection = JdbcTools.getConnection();
//			result = dao.searchOrder(connection, order);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JdbcTools.releaseResource(null, connection);
//		}
//		return result;
		return null;
	}
	
	public void addOrderItem(OrderItem orderItem){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.addOrderItem(connection, orderItem);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public List<OrderItem> getOrderItemList(int id){
		Connection connection = null;
		List<OrderItem> orderItems = null;
		try {
			connection = JdbcTools.getConnection();
			orderItems = dao.fetchAllOrderItem(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return orderItems;
	}
	
	public List<OrderItem> getOrderItemList(){
		Connection connection = null;
		List<OrderItem> orderItems = null;
		try {
			connection = JdbcTools.getConnection();
			orderItems = dao.fetchAllOrderItem(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return orderItems;
	}
	
	public void deleteOrderItem(int id){
//		Connection connection = null;
//		try {
//			connection = JdbcTools.getConnection();
//			dao.deleteCartItem(connection, id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JdbcTools.releaseResource(null, connection);
//		}
	}
	
	
	public void updateOrderItem(OrderItem orderItem){
//		Connection connection = null;
//		try {
//			connection = JdbcTools.getConnection();
//			dao.updateCartItem(connection, cartItem);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JdbcTools.releaseResource(null, connection);
//		}
	}
}