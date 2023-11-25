package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.shop.bean.Admin;
import com.shop.dao.AdminDao;

public class AdminDaoJdbcImpl extends DaoJdbcImpl<Admin> implements AdminDao{
	
	public AdminDaoJdbcImpl() {
		super();
	}
	@Override
	public Admin searchAdmin(Connection connection, Admin admin) throws SQLException {
		String sql = "SELECT * FROM admin WHERE AdminName = ? AND Password = ?;";
		Object[] objects = {admin.getAdminname(), admin.getPassword()};
		return fetch(connection, sql, objects);
	}
}
