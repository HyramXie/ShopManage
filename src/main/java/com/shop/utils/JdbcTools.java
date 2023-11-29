package com.shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcTools {
	private static ComboPooledDataSource cpds = null;
	public static Connection getConnection() throws Exception{
		if(cpds == null) 
			cpds  = new ComboPooledDataSource("com.shop.javaweb");
		return cpds.getConnection();
	}
	
//	public static Connection getConnection() throws Exception {
//		String driverClass = "com.mysql.cj.jdbc.Driver";
//		String jdbcUrl = "jdbc:mysql://localhost:3306/shop";
//		String user = "root";
//		String password = "mysql";
//		Class.forName(driverClass);
//		
//		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
//		return connection;
//	}
	
	public static void releaseResource(Statement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}
}
