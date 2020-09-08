
package com.kgisl.electronicstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.kgisl.electronicstore.dao.CartDAO;
import com.kgisl.electronicstore.exceptionhandler.CartException;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Cart;

/*
 * @author nivetha
 * @author aarthi
 * @since 27,dec,2019
 */
public class CartDAOimpl implements CartDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * select the cartid,itemid,customerid,count from the cart table in database and add the
	 * cartid,itemid,customerid,count  in the listCart using RowMapper and return the listCart
	 */

	public List<Cart> cartList() {
String sql = "SELECT * FROM cart";
		List<Cart> listCart = template.query(sql, new RowMapper<Cart>() {
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart c = new Cart();
				c.setCartid(rs.getInt("Cartid"));
				c.setItemid(rs.getInt("itemid"));
				c.setCustomerid(rs.getInt("customerid"));
				c.setCount(rs.getInt("count"));

				return c;
			}

		});

		return listCart;

	}

	/*
	 * get the count of the customerid in the cart table by using the select statement.
	 * insert the itemid,customerid and the count in the cart table
	 */
	
	public void cartInsert(int id, int cusid) throws NullpointerException {
		if(id==0 && cusid==0) {
			throw new NullpointerException();	
		}
		else {
		RowCountCallbackHandler handler = new RowCountCallbackHandler();
		template.query("SELECT customerid FROM cart WHERE customerid='" + cusid + "'", handler);
int max = handler.getRowCount();
		max++;
		String sql = "insert into cart(itemid,customerid,count) values('" + id + "','" + cusid + "','" + max + "')";
		template.update(sql);

	}}
			
	/*
	 * select the count from the cart table where the customer id is equal to the cusid and delete the rows 
	 * and update the count 
	 */

	public void cartDelete(int id, int cusid) throws CartException {
String sql2 = "select count from cart where `itemid`='" + id + "' AND `customerid`='" + cusid + "'";
		List<Cart> listCart = template.query(sql2, new RowMapper<Cart>() {
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart c = new Cart();
				c.setCount(rs.getInt("count"));

				return c;
			}

		});
		for (Cart a : listCart) {
			int z = a.getCount();

			String sql = "delete from `cart` where `itemid`='" + id + "' AND `customerid`='" + cusid + "'";

			String sql1 = "update cart set count=count-1 where customerid='" + cusid + "' AND count>'" + z + "'";

			template.update(sql);
			template.update(sql1);

		}
	}
/*
 * mapping the category table ,product table, items table and cart table using inner join
 */
	public List<Cart> cartMap(int cusid) throws NullpointerException {
if(cusid==0) {
			
			throw new NullpointerException();
			
		}
		else {
		String sql = "select ca.itemid,imgsrc,productname,productmodel,productprice,categoryname,cartid,count,customerid from product p inner join category c on p.categoryid=c.categoryid inner join items i on p.productid=i.productid inner join cart ca on i.itemid=ca.itemid where ca.customerid='"
				+ cusid + "'";
		List<Cart> listCart = template.query(sql, new RowMapper<Cart>() {
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cart i = new Cart();

				i.setProductname(rs.getString("productname"));
				i.setItemid(rs.getInt("itemid"));
				
				i.setProductprice(rs.getFloat("productprice"));
				i.setProductmodel(rs.getString("productmodel"));
				i.setCategoryname(rs.getString("categoryname"));
				i.setCartid(rs.getInt("cartid"));
				i.setCount(rs.getInt("count"));
				i.setCustomerid(rs.getInt("customerid"));
				i.setImgsrc(rs.getString("imgsrc"));
				return i;
			}

		});
		return listCart;

	}
	}

}
