package com.shop.service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.daoImpl.UserDaoJdbcImpl;
import com.shop.utils.JdbcTools;
import com.mysql.cj.xdevapi.Result;

public class UserService {
	private UserDao dao;
	
	public UserService() {
		this.dao = new UserDaoJdbcImpl();
	}
	
	public User checkUser(User user){
		Connection connection = null;
		User user1 = null;
		try {
			connection = JdbcTools.getConnection();
			user1 = dao.searchUser(connection, user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return user1;
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
	
}
