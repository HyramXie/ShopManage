package com.shop.service;

import java.sql.Connection;
import java.util.List;

import com.shop.bean.Category;
import com.shop.dao.CategoryDao;
import com.shop.daoImpl.CategoryDaoJdbcImpl;
import com.shop.utils.JdbcTools;

public class CategoryService {
	private CategoryDao dao;
	
	public CategoryService() {
		this.dao = new CategoryDaoJdbcImpl();
	}
	
	public boolean checkCategory(Category category){
		Connection connection = null;
		boolean result = false;
		try {
			connection = JdbcTools.getConnection();
			if(dao.searchCategory(connection, category) != null)
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public Category checkCategory(int id){
		Connection connection = null;
		Category result = null;
		try {
			connection = JdbcTools.getConnection();
			result = dao.searchCategory(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return result;
	}
	
	public void addCategory(Category category){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.addCategory(connection, category);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public List<Category> getCategoryList(){
		Connection connection = null;
		List<Category> categories = null;
		try {
			connection = JdbcTools.getConnection();
			categories = dao.fetchAllCategory(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
		return categories;
	}
	
	public void deleteCategory(int id){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.deleteCategory(connection, id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
	public void updateCategory(Category category){
		Connection connection = null;
		try {
			connection = JdbcTools.getConnection();
			dao.updateCategory(connection, category);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTools.releaseResource(null, connection);
		}
	}
	
}
