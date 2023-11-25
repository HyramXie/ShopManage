package com.shop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.Category;

public interface CategoryDao {
	public void addCategory(Connection connection, Category category) throws SQLException;

	public void deleteCategory(Connection connection, String name) throws SQLException;
	
	public void updateCategory(Connection connection, Category category) throws SQLException;

	public Category searchCategory(Connection connection, Category category) throws SQLException;
	
	public List<Category> fetchAllCategory(Connection connection) throws SQLException;

}
