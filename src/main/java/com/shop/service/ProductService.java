package com.shop.service;

import java.sql.Connection;
import java.util.List;

import com.shop.bean.Product;
import com.shop.dao.ProductDao;
import com.shop.daoImpl.ProductDaoJdbcImpl;
import com.shop.utils.JdbcTools;

public class ProductService {
	private ProductDao dao;
	
	public ProductService() {
		this.dao = new ProductDaoJdbcImpl();
	}
	
	public boolean checkCategory(Product product){
		Connection connection = null;
		boolean result = false;
		try {
			connection = JdbcTools.getConnection();
			if(dao.searchProduct(connection, product) != null)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public void addCategory(Product product){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.addProduct(connection, product);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public List<Product> getCategoryList(){
		Connection connection = null;
		List<Product> products = null;
		try {
			connection = JdbcTools.getConnection();
			products = dao.fetchAllProduct(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return products;
	}
}
