
package com.kgisl.electronicstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kgisl.electronicstore.dao.ProductDAO;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Product;

/*
 * @author nivetha
 * @author aarthi
 * @since 30,dec,2019
 */
public class ProductDAOimpl implements ProductDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * select the Product name from the Product table in database and add the
	 * Product name in the listProduct using RowMapper and return the listProduct
	 */

	public List<Product> productList() {
		String sql = "SELECT * FROM product";
		List<Product> listProduct = template.query(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setProductid(rs.getInt("productid"));
				p.setProductname(rs.getString("productname"));
				p.setCategoryid(rs.getInt("categoryid"));
//p.setImgsrc(rs.getString("imgsrc"));
				return p;
			}

		});

		return listProduct;
	}

	/*
	 * insert the Product name into the Product table
	 */

	public int productInsert(Product p) throws NullpointerException {
		if (p.getProductname() == "") {
			throw new NullpointerException();
		} else {
			String sql = "insert into product(categoryid,productid,productname) values('" + p.getCategoryid() + "','"
					+ p.getProductid() + "','" + p.getProductname() + "')";

			return template.update(sql);
		}
	}

	/*
	 * delete the Productname using Product id from the Product table
	 */

	public int productDelete(int id) {
		String sql = "delete from product where productid=" + id + "";
		return template.update(sql);
	}

	/*
	 * get single Product from the Product table using select query
	 */

	public List<Product> productGetById(int id) {
		String sql = "select * from product where productid='" + id + "'";
		List<Product> getlist = template.query(sql, new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setCategoryid(rs.getInt("categoryid"));
				p.setProductid(rs.getInt("productid"));
				p.setProductname(rs.getString("productname"));
				return p;
			}

		});

		return getlist;

	}

	/*
	 * update the productname using Product id from the Product table
	 */

	public int productUpdate(Product p) throws NullpointerException {
		if (p.getProductname() == "") {
			throw new NullpointerException();
		} else {
			String sql = "update product set productname='" + p.getProductname() + "' where productid="
					+ p.getProductid() + "";

			return template.update(sql);
		}
	}

	
	

}
