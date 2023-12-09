package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.Order;
import com.shop.dao.OrderDao;
public class OrderDaoJdbcImpl extends DaoJdbcImpl<Order> implements OrderDao{

	@Override
	public Object addOrder(Connection connection, Order order) throws SQLException {
		String sql = "INSERT INTO `order` (UserID, OrderDate, `Status`, Price, Address) VALUES (?, ?, ?, ?, ?);";
		Object[] objects = {order.getUserID(), order.getOrderDate(), order.getStatus(), order.getPrice(), order.getAddress()};
		update(connection, sql, objects);
		String sql1 = "SELECT LAST_INSERT_ID();";
		return fetchScaler(connection, sql1);
	}

	@Override
	public void deleteOrder(Connection connection, int id) throws SQLException {
		String sql = "DELETE FROM `order` WHERE OrderID=?;";
		Object[] objects = {id};
		update(connection, sql, objects);
		
	}

	@Override
	public void updateOrder(Connection connection, int orderID, int status) throws SQLException {
		String sql = "UPDATE `order` SET  `Status` = ? WHERE OrderID=?;";
		Object[] objects = {status, orderID};
		update(connection, sql, objects);
	}
	
	@Override
	public void updateOrder(Connection connection, int orderID, int status, String address) throws SQLException {
		String sql = "UPDATE `order` SET  `Status` = ?, Address = ? WHERE OrderID=?;";
		Object[] objects = {status, address, orderID};
		update(connection, sql, objects);
	}

	@Override
	public Order searchOrder(Connection connection, int id) throws SQLException {
		String sql = "SELECT *	FROM `order`	WHERE OrderID = ?";
		Object[] objects = {id};
		return fetch(connection, sql, objects);
	}

	@Override
	public List<Order> fetchAllOrder(Connection connection, int id) throws SQLException {
		String sql = "SELECT *	FROM `order`	WHERE UserID = ?";
		Object[] objects = {id};
		return fetchList(connection, sql, objects);
	}
	
	public List<Order> fetchAllOrder(Connection connection) throws SQLException {
		String sql = "SELECT *	FROM `order`;";
		Object[] objects = {};
		return fetchList(connection, sql, objects);
	}

}
