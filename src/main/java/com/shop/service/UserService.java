package com.shop.service;

import java.sql.Connection;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.daoImpl.UserDaoJdbcImpl;
import com.shop.utils.JdbcTools;

public class UserService {
	private UserDao dao;
	
	public UserService() {
		this.dao = new UserDaoJdbcImpl();
	}
	
	public User searchUser(User user){
		Connection connection = null;
		User result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.searchUser(connection, user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public void registUser(User user){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.addUser(connection, user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public void changeUser(User user){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateUser(connection, user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public User checkUser(User user){
		Connection connection = null;
		User result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.checkUser(connection, user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
}
