package com.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.Order;

public interface OrderDao {
	
	public Object addOrder(Connection connection, Order order) throws SQLException;

	public void deleteOrder(Connection connection, int id) throws SQLException;
	
	public void updateOrder(Connection connection, int orderID, int status) throws SQLException;
	
	public void updateOrder(Connection connection, int orderID, int status, String address, String name, String phone) throws SQLException;
	
	public Order searchOrder(Connection connection, int id) throws SQLException;
	
	public List<Order> fetchAllOrder(Connection connection, int id) throws SQLException;
	
	public List<Order> fetchAllOrder(Connection connection) throws SQLException;

}

