package com.shop.service;

import java.sql.Connection;

import com.shop.bean.Admin;
import com.shop.dao.AdminDao;
import com.shop.daoImpl.AdminDaoJdbcImpl;
import com.shop.utils.JdbcTools;

public class AdminService {
	private AdminDao dao;
	
	public AdminService() {
		this.dao = new AdminDaoJdbcImpl();
	}
	
	public Admin checkAdmin(Admin admin){
		Connection connection = null;
		Admin admin1 = null;
		try {
			connection = JdbcTools.getConnection();
			admin1 = dao.searchAdmin(connection, admin);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return admin1;
	}
	
}
