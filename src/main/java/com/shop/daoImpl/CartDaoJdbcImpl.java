package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.CartItem;
import com.shop.dao.CartDao;


public class CartDaoJdbcImpl extends DaoJdbcImpl<CartItem> implements CartDao{
	
	@Override
	public void addCartItem(Connection connection, CartItem cartItem) throws SQLException {
		String sql = "INSERT INTO cartitem (UserID, ProductID, Quantity) VALUES (?, ?, ?);";
		Object[] objects = {cartItem.getUserID(), cartItem.getProductID(), cartItem.getQuantity()};
		update(connection, sql, objects);
	}

	@Override
	public void deleteCartItem(Connection connection, int id) throws SQLException {
//		String sql = "DELETE FROM product WHERE ProductID=?;";
//		Object[] objects = {id};
//		update(connection, sql, objects);
	}

	@Override
	public void updateCartItem(Connection connection, CartItem cartItem) throws SQLException {
		String sql = "UPDATE cartitem SET Quantity=? WHERE ProductID=?;";
		Object[] objects = {cartItem.getQuantity(), cartItem.getProductID()};
		update(connection, sql, objects);
		
	}

	@Override
	public CartItem searchCartItem(Connection connection, int id) throws SQLException {
		String sql = "SELECT * FROM cartitem WHERE ProductID=?;";
		Object[] objects = {id};
		return fetch(connection, sql, objects);
	}

	@Override
	public List<CartItem> fetchAllCartItem(Connection connection, int id) throws SQLException {
		String sql = "SELECT c.CartItemID, c.ProductID, p.ProductName, p.Price, c.Quantity\r\n"
				+ "FROM cartitem c	JOIN product p ON c.ProductID = p.ProductID\r\n"
				+ "WHERE c.UserID = ?";
		Object[] objects = {id};
		return fetchList(connection, sql, objects);
	}

}

