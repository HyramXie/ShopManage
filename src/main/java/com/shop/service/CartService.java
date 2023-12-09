package com.shop.service;

import java.sql.Connection;
import java.util.List;

import com.shop.bean.CartItem;
import com.shop.dao.CartDao;
import com.shop.daoImpl.CartDaoJdbcImpl;
import com.shop.utils.JdbcTools;

public class CartService {
	private CartDao dao;
	
	public CartService() {
		this.dao = new CartDaoJdbcImpl();
	}
	
	public CartItem checkCartItem(int id, int userID){
		Connection connection = null;
		CartItem result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.searchCartItem(connection, id, userID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public void addCartItem(CartItem cartItem){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.addCartItem(connection, cartItem);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public List<CartItem> getCartItemList(int id){
		Connection connection = null;
		List<CartItem> cartItems = null;
		try {
			connection = JdbcTools.getConnection();
			cartItems = dao.fetchAllCartItem(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return cartItems;
	}
	
	public void deleteCartItem(int id){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.deleteCartItem(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	
	public void updateCartItem(CartItem cartItem){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateCartItem(connection, cartItem);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
}

