
package com.kgisl.electronicstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kgisl.electronicstore.dao.ItemsDAO;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Items;


/*
 * @author nivetha
 * @author aarthi
 * @since 30,dec,2019
 */
public class ItemsDAOimpl implements ItemsDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * select the Product model,product price,productid,itemid from the items table
	 * in database and add the Product model,product price,productid,itemid in the
	 * listitems using RowMapper and return the listitem
	 */

	public List<Items>  itemsList() {
		String sql = "SELECT * FROM items";
		List<Items> listItems = template.query(sql, new RowMapper<Items>() {
			public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
				Items i = new Items();
				i.setProductid(rs.getInt("productid"));
				i.setProductmodel(rs.getString("productmodel"));
				i.setItemid(rs.getInt("itemid"));
				i.setProductprice(rs.getFloat("productprice"));
				return i;
			}

		});

		return listItems;
	}

	/*
	 * insert the itemid,productid,productmodel,productprice into the items table
	 */

	public int itemsInsert(Items i) throws NullpointerException {
		if (i.getProductprice() == 0.0) {
			throw new NullpointerException();
		} else {
			String sql = "insert into items(itemid,productid,productmodel,productprice) values('" + i.getItemid()
					+ "','" + i.getProductid() + "','" + i.getProductmodel() + "','" + i.getProductprice() + "')";

			return template.update(sql);
		}
	}

	/*
	 * delete all fields from item using item id
	 */

	public int itemsDelete(int id) {
		String sql = "delete from items where itemid=" + id + "";

		return template.update(sql);
	}

	/*
	 * get single item from the items table using select query
	 */

	public List<Items>  itemsGetById(int id) {
		String sql = "select * from items where itemid='" + id + "'";
		List<Items> getlist = template.query(sql, new RowMapper<Items>() {
			public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
				Items i = new Items();
				i.setProductid(rs.getInt("productid"));
				i.setProductmodel(rs.getString("productmodel"));
				i.setItemid(rs.getInt("itemid"));
				i.setProductprice(rs.getFloat("productprice"));
				return i;
			}

		});

		return getlist;

	}

	/*
	 * update the fields using item id from the items table
	 */
	public int itemsUpdate(Items i) throws NullpointerException {
		if (i.getProductprice() == 0.0) {
			throw new NullpointerException();
		} else {
			String sql = "update items set productprice='" + i.getProductprice() + "',productmodel='"
					+ i.getProductmodel() + "' where itemid=" + i.getItemid() + "";

			return template.update(sql);
		}
	}

	/*
	 * mapping the category table,producttable,itemtable using inner join
	 */


	public List<Items>  itemsMapall(int id) {
		String sql = "select itemid,p.productid,productname,productmodel,productprice,categoryname,imgsrc from product p inner join category c on p.categoryid=c.categoryid inner join items i on p.productid=i.productid where i.itemid='"+id+"'";
		List<Items> listProduct = template.query(sql, new RowMapper<Items>() {
			public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
				Items i = new Items();
				i.setProductid(rs.getInt("productid"));
				i.setProductname(rs.getString("productname"));
				i.setItemid(rs.getInt("itemid"));
				i.setProductprice(rs.getFloat("productprice"));
				i.setProductmodel(rs.getString("productmodel"));
				i.setCategoryname(rs.getString("categoryname"));
i.setImgsrc(rs.getString("imgsrc"));
				return i;
			}

		});

		return listProduct;

	}

	public List<Items>  itemsMapByCategory(int id) {
		String sql = "select itemid,p.productid,productname,productmodel,productprice,p.categoryid,categoryname,imgsrc from product p inner join category c on p.categoryid=c.categoryid inner join items i on p.productid=i.productid where p.categoryid='"
				+ id + "'";
		List<Items> listProduct = template.query(sql, new RowMapper<Items>() {
			public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
				Items i = new Items();
				i.setCategoryid(rs.getInt("categoryid"));
				i.setProductname(rs.getString("productname"));
				i.setItemid(rs.getInt("itemid"));
				i.setProductprice(rs.getFloat("productprice"));
				i.setProductmodel(rs.getString("productmodel"));
				i.setCategoryname(rs.getString("categoryname"));
i.setImgsrc(rs.getString("imgsrc"));
				return i;
			}

		});

		return listProduct;

}
	
}
