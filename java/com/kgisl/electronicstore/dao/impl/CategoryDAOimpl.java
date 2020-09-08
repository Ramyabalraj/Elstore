package com.kgisl.electronicstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kgisl.electronicstore.dao.CategoryDAO;

import com.kgisl.electronicstore.exceptionhandler.CategoryException;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Category;

/*
 * @author nivetha
 * @author aarthi
 * @since 27,dec,2019
 */
public class CategoryDAOimpl implements CategoryDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * select the category name from the category table in database and add the
	 * category name in the listCategory using RowMapper and return the listCategory
	 */

	
	public List<Category> getAllCategories() {
		String sql = "SELECT * FROM category";
	
		List<Category> listCategory = template.query(sql, new RowMapper<Category>() {
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Category p = new Category();
				p.setCategoryid(rs.getInt("categoryid"));
				p.setCategoryname(rs.getString("categoryname"));
			
				return p;
			
			}

		});

		return listCategory;

	}


	/*
	 * insert the category name into the category table
	 */

	public int categoryInsert(Category c) throws NullpointerException {
		if (c.getCategoryname() == "") {
			throw new NullpointerException();
		} else {
			String sql = "insert into category(categoryname) values('" + c.getCategoryname() + "')";

			return template.update(sql);
		}
	}

	/*
	 * delete the categoryname using category id from the category table
	 */

	public int categoryDelete(int id) throws CategoryException {

		String sql = "delete from category where categoryid=" + id + "";
		return template.update(sql);

	}

	/*
	 * get single category from the category table using select query
	 */
	public List<Category> getCategoryByid(int id) throws SQLException {
		String sql = "select * from category where categoryid='" + id + "'";
		List<Category> getlist = template.query(sql, new RowMapper<Category>() {
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category p = new Category();
				p.setCategoryid(rs.getInt("categoryid"));
				p.setCategoryname(rs.getString("categoryname"));
				return p;

			}

		});
		return getlist;

	}


	/*
	 * update the categoryname using category id from the category table
	 */

	public int categoryUpdate(Category c) throws NullpointerException {
		if (c.getCategoryname() == "") {

			throw new NullpointerException();

		} else {
			String sql = "update category set categoryname='" + c.getCategoryname() + "' where categoryid="
					+ c.getCategoryid() + "";

			return template.update(sql);
		}
	}






	
	

	



}
