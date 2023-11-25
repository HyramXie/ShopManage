package com.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.shop.bean.User;




public interface UserDao {
	public void addUser(Connection connection, User user) throws SQLException;

	public void updateUser(Connection connection, User user) throws SQLException;

	public User searchUser(Connection connection, User user) throws SQLException;

}
