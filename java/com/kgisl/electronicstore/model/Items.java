package com.kgisl.electronicstore.model;

import java.io.ObjectInputStream.GetField;

public class Items {
	private int itemid;
	private String productmodel;
	private Float productprice;
	private int productid;
	private String productname;
	private String categoryname;
	private String imgsrc;
	private int categoryid;
	
public Items(int itemid, String productmodel, Float productprice, int productid, String productname,
			String categoryname, String imgsrc,int categoryid) {
		super();
		this.itemid = itemid;
		this.productmodel = productmodel;
		this.productprice = productprice;
		this.productid = productid;
		this.productname = productname;
		this.categoryname = categoryname;
		this.imgsrc = imgsrc;
		this.categoryid = categoryid;
	}
public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public Items(int itemid, String productmodel, Float productprice, int productid, String productname,
		String categoryname,int categoryid) {

	this.itemid = itemid;
	this.productmodel = productmodel;
	this.productprice = productprice;
	this.productid = productid;
	this.productname = productname;
	this.categoryname = categoryname;
	this.categoryid = categoryid;
}
	public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
	public Items(int itemid, String productmodel, Float productprice, int productid) {
		
		this.itemid = itemid;
		this.productmodel = productmodel;
		this.productprice = productprice;
		this.productid = productid;
	}
	public Items() {
		
	}
	public Float getProductprice() {
		return productprice;
	}

	public void setProductprice(Float productprice) {
		this.productprice = productprice;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getProductmodel() {
		return productmodel;
	}

	public void setProductmodel(String productmodel) {
		this.productmodel = productmodel;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String toString() {
        
		   return itemid+" "+productmodel+" "+productprice+" "+productname+ " "+productid+"  "+categoryname;
//	        return String.format(productname,categoryname,productid);
	    }
	public void setProductname(String productname) {
		this.productname = productname;
		
	}
	public String getProductname() {
		return productname;
	}
	public void setCategoryid(int int1) {
		// TODO Auto-generated method stub
		this.categoryid = categoryid;	
	}
	public int getCategoryid() {
		return categoryid;
	}
}
