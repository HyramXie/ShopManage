package com.shop.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.shop.bean.Category;
import com.shop.dao.CategoryDao;

public class CategoryDaoJdbcImpl extends DaoJdbcImpl<Category> implements CategoryDao{

	public CategoryDaoJdbcImpl() {
		super();
	}

	@Override
	public void addCategory(Connection connection, Category category) throws SQLException {
		String sql = "INSERT INTO category (CategoryName) VALUES (?);";
		Object[] objects = {category.getCategoryName()};
		update(connection, sql, objects);
		
	}
	@Override
	public void deleteCategory(Connection connection, int id) throws SQLException {
		String sql = "DELETE FROM category WHERE CategoryID=?;";
		Object[] objects = {id};
		update(connection, sql, objects);
		
	}
	@Override
	public void updateCategory(Connection connection, Category category) throws SQLException {
		String sql = "UPDATE category SET  CategoryName = ? WHERE CategoryID=?;";
		Object[] objects = { category.getCategoryName(), category.getCategoryID()};
		update(connection, sql, objects);
		
	}
	@Override
	public Category searchCategory(Connection connection, Category category) throws SQLException {
		String sql = "SELECT * FROM category WHERE CategoryName = ?;";
		Object[] objects = {category.getCategoryName()};
		return fetch(connection, sql, objects);
	}
	@Override
	public Category searchCategory(Connection connection, int id) throws SQLException {
		String sql = "SELECT * FROM category WHERE CategoryID = ?;";
		Object[] objects = {id};
		return fetch(connection, sql, objects);
	}
	@Override
	public List<Category> fetchAllCategory(Connection connection) throws SQLException {
		String sql = "SELECT * FROM category";
		return fetchList(connection, sql);
	}

}

