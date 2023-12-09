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
	
	public Product checkProduct(Product product){
		Connection connection = null;
		Product result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.searchProduct(connection, product);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public Product checkProduct(int id){
		Connection connection = null;
		Product result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.searchProduct(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public void addProduct(Product product){
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
	
	public List<Product> getProductList(){
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
	
	public void deleteProduct(int id){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.deleteProduct(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public void updateProduct(Product product){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateProduct(connection, product);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public void updateProduct(int id){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateProduct(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public void updateProduct(int id, int quantity){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateProduct(connection, id, quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
}
