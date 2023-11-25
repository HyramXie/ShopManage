package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.shop.bean.User;
import com.shop.dao.UserDao;

public class UserDaoJdbcImpl extends DaoJdbcImpl<User> implements UserDao{

	public UserDaoJdbcImpl() {
		super();
	}
	@Override
	public void addUser(Connection connection, User user) throws SQLException {
		String sql = "INSERT INTO user (Username, Password, Email, PhoneNumber) VALUES (?, ?, ?, ?);";
		Object[] objects = {user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber()};
		update(connection, sql, objects);
	}

	@Override
	public void updateUser(Connection connection, User user) throws SQLException {
		String sql = "UPDATE user SET Username = ?,  Password = ?, Email = ?, PhoneNumber = ?	WHERE UserID = ?;";
		Object[] objects = { user.getUsername(),user.getPassword(), user.getEmail(), user.getPhoneNumber(), user.getUserID()};
		update(connection, sql, objects);
	}

	@Override
	public User searchUser(Connection connection, User user) throws SQLException {
		String sql = "SELECT * FROM user WHERE Username = ? AND Password = ?;";
		Object[] objects = {user.getUsername(), user.getPassword()};
		return fetch(connection, sql, objects);
	}
}
