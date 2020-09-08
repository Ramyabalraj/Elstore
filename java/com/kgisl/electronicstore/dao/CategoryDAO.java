package com.kgisl.electronicstore.dao;


import java.sql.SQLException;
import java.util.List;

import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.exceptionhandler.CategoryException;
import com.kgisl.electronicstore.model.Category;

public interface CategoryDAO {
	
	public int  categoryInsert(Category c) throws NullpointerException;
	public int  categoryDelete(int id) throws CategoryException;
	
	public int categoryUpdate(Category c)throws NullpointerException;
	public List<Category> getCategoryByid(int id) throws SQLException;
	public List<Category> getAllCategories();

	
}
