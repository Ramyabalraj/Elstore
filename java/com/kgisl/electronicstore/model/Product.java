package com.kgisl.electronicstore.model;

public class Product {

	private int productid;
	private String productname;
	private int categoryid;
private String categoryname;
private String imgsrc;
	public Product(int productid, String productname, int categoryid, String categoryname, String imgsrc) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.categoryid = categoryid;
	this.categoryname = categoryname;
	this.imgsrc = imgsrc;
}

	public String getImgsrc() {
	return imgsrc;
}

public void setImgsrc(String imgsrc) {
	this.imgsrc = imgsrc;
}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
public String toString() {
        
	   return productname+" "+categoryname+" "+productid+" "+imgsrc;
//        return String.format(productname,categoryname,productid);
    }

	public Product() {

	}

	public Product(int productid, String productname) {
		this.productid = productid;
		this.productname = productname;
	}
	public Product(int productid, String productname,int categoryid) {
		this.productid = productid;
		this.productname = productname;
		this.categoryid = categoryid;
	}
	public Product(int productid, String productname,String categoryname) {
		this.categoryname = categoryname;

		this.productid = productid;
		this.productname = productname;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
}
