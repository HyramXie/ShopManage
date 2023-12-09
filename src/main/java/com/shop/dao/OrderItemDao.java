package com.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.OrderItem;

public interface OrderItemDao {
	public void addOrderItem(Connection connection, OrderItem orderItem) throws SQLException;

	public void deleteOrderItem(Connection connection, int id) throws SQLException;
	
	public void updateOrderItem(Connection connection, OrderItem orderItem) throws SQLException;
	
	public OrderItem searchOrderItem(Connection connection, int id) throws SQLException;
	
	public List<OrderItem> fetchAllOrderItem(Connection connection, int id) throws SQLException;
	
	public List<OrderItem> fetchAllOrderItem(Connection connection) throws SQLException;
}
