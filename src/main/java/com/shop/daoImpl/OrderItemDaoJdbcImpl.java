package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.OrderItem;
import com.shop.dao.OrderItemDao;

public class OrderItemDaoJdbcImpl extends DaoJdbcImpl<OrderItem> implements OrderItemDao{
	@Override
	public void addOrderItem(Connection connection, OrderItem orderItem) throws SQLException {
		String sql = "INSERT INTO `orderitem` (OrderID, ProductID, ProductName, Quantity) VALUES (?, ?, ?, ?);";
		Object[] objects = {orderItem.getOrderID(), orderItem.getProductID(), orderItem.getProductName(), orderItem.getQuantity()};
		update(connection, sql, objects);
	}

	@Override
	public void deleteOrderItem(Connection connection, int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderItem(Connection connection, OrderItem orderItem) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderItem searchOrderItem(Connection connection, int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> fetchAllOrderItem(Connection connection, int id) throws SQLException {
		String sql = "SELECT OrderID, OrderItemID, ProductID, Quantity, ProductName	FROM orderitem WHERE OrderID = ?";
		Object[] objects = {id};
		return fetchList(connection, sql, objects);
	}
	
	public List<OrderItem> fetchAllOrderItem(Connection connection) throws SQLException {
		String sql = "SELECT OrderID, OrderItemID, ProductID, Quantity, ProductName FROM orderitem";
		Object[] objects = {};
		return fetchList(connection, sql, objects);
	}
}
