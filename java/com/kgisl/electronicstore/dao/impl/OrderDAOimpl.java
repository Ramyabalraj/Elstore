package com.kgisl.electronicstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kgisl.electronicstore.dao.OrderDAO;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.exceptionhandler.OrderException;
import com.kgisl.electronicstore.model.Cart;
import com.kgisl.electronicstore.model.Order;

/*
 * @author nivetha
 * @author aarthi
 * @since 27,dec,2019
 */
public class OrderDAOimpl implements OrderDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * select the cartid,itemid,customerid,orderid from the order table in database and add the
	 *cartid,itemid,customerid,orderid in the listorder using RowMapper and return the listorder 
	 */

	public List<Order> orderList() {

		String sql = "SELECT `cartid`, `itemid`, `customerid`, `orderid` FROM `nivi`.`orders` ";

		List<Order> listOrder = template.query(sql, new RowMapper<Order>() {
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order o = new Order();
				o.setCartid(rs.getInt("cartid"));
				o.setItemid(rs.getInt("itemid"));
				o.setCustomerid(rs.getInt("customerid"));
				o.setOrderid(rs.getInt("orderid"));
				return o;
			}

		});

		return listOrder;

	}

	/*
	 * insert the itemid and customerid into the order table
	 */
	public int orderInsert(int itemid, int cusid) throws NullpointerException {

		if (itemid == 0 && cusid == 0) {

			throw new NullpointerException();

		} else {
			String sql = "INSERT INTO `nivi`.`orders` (`itemid`, `customerid`) VALUES ('" + itemid + "','" + cusid + "');";
			return template.update(sql);
		}
	}

	/*
	 * delete the allfields in the row using itemid, customerid from the order table
	 */

	public int orderDelete(int id, int cusid) throws OrderException {
		String sql = "DELETE FROM `nivi`.`orders` WHERE  `itemid`='" + id + "' AND `customerid`='" + cusid + "'";
		return template.update(sql);

	}

	/*
	 * insert the cartid into the order table
	 */
	
	public int orderInsertCart(int id) {

		String sql = "INSERT INTO `nivi`.`orders` ( `cartid`) VALUES ('" + id + "')";
		return template.update(sql);
	}
	
	/*
	 * delete the allfields in the row using cartid from the order table
	 */
	
	public int orderDeleteCart(int id) throws OrderException {
		String sql = "DELETE FROM `nivi`.`orders` WHERE  `cartid`='" + id + "'";
		return template.update(sql);

	}
	
	/*
	 * mapping the category table ,product table, items table and cart table using inner join
	 */
		public List<Order> orderMapCust(int cusid) throws NullpointerException {
	if(cusid==0) {
				
				throw new NullpointerException();
				
			}
			else {
			String sql = "select o.itemid,imgsrc,productname,productmodel,productprice,categoryname,customerid from  `nivi`.`product` p"
					+ " inner join  `nivi`.`category` c on p.categoryid=c.categoryid "
					+ "inner join  `nivi`.`items` i on p.productid=i.productid "
					+ "inner join  `nivi`.`orders` o on i.itemid=o.itemid"
					+ " where o.customerid='"+cusid+"'";
		List<Order> listOrder = template.query(sql, new RowMapper<Order>() {
				public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
					Order i = new Order();

					i.setProductname(rs.getString("productname"));
					i.setItemid(rs.getInt("itemid"));
					
					i.setProductprice(rs.getFloat("productprice"));
					i.setProductmodel(rs.getString("productmodel"));
					i.setCategoryname(rs.getString("categoryname"));
				
					
					i.setCustomerid(rs.getInt("customerid"));
					i.setImgsrc(rs.getString("imgsrc"));
					return i;
				}

			});
			return listOrder;

		}
		}

}
