package com.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.CartItem;


public interface CartDao {
	public void addCartItem(Connection connection, CartItem cartItem) throws SQLException;

	public void deleteCartItem(Connection connection, int id) throws SQLException;
	
	public void updateCartItem(Connection connection, CartItem cartItem) throws SQLException;
	
	public CartItem searchCartItem(Connection connection, int id, int userID) throws SQLException;
	
	public List<CartItem> fetchAllCartItem(Connection connection, int id) throws SQLException;
}

