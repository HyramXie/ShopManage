package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.User;
import com.shop.dao.UserDao;

public class UserDaoJdbcImpl extends DaoJdbcImpl<User> implements UserDao{

	public UserDaoJdbcImpl() {
		super();
	}
	@Override
	public void addUser(Connection connection, User user) throws SQLException {
		String sql = "INSERT INTO `user` (name, password) VALUES (?, ?);";
		Object[] objects = {user.getUsername(), user.getPassword()};
		update(connection, sql, objects);
	}

	@Override
	public void deleteUser(Connection connection, String name) throws SQLException {
		String sql = "DELETE FROM user WHERE name = ?;";
		Object[] objects = {name};
		update(connection, sql, objects);
	}

	@Override
	public void updateUser(Connection connection, User user) throws SQLException {
		String sql = "UPDATE user SET password = ?	WHERE name = ?;";
		Object[] objects = { user.getPassword(), user.getUsername()};
		update(connection, sql, objects);
	}

	@Override
	public User searchUser(Connection connection, User user) throws SQLException {
		String sql = "SELECT * FROM user WHERE name = ? AND password = ?;";
		Object[] objects = {user.getUsername(), user.getPassword()};
		return fetch(connection, sql, objects);
	}

	@Override
	public List<User> fetchAllUser(Connection connection) throws SQLException {
		String sql = "SELECT * FROM `user`";
		return fetchList(connection, sql);
	}

}
