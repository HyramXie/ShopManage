package com.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.shop.bean.Admin;




public interface AdminDao {
	public Admin searchAdmin(Connection connection, Admin admin) throws SQLException;

}
