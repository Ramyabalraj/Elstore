package com.kgisl.electronicstore.model;

public class Cart {
private int itemid;
private int customerid;
private int cartid;
private String productmodel;
private Float productprice;
private int productid;
private String productname;
private String categoryname;
private int count;
private String imgsrc;


public Cart(int itemid, int customerid, int cartid, String productmodel, Float productprice, int productid,
		String productname, String categoryname, int count, String imgsrc) {
	super();
	this.itemid = itemid;
	this.customerid = customerid;
	this.cartid = cartid;
	this.productmodel = productmodel;
	this.productprice = productprice;
	this.productid = productid;
	this.productname = productname;
	this.categoryname = categoryname;
	this.count = count;
	this.imgsrc = imgsrc;
}

public String getImgsrc() {
	return imgsrc;
}

public void setImgsrc(String imgsrc) {
	this.imgsrc = imgsrc;
}

public Cart(int itemid, int customerid, int cartid, String productmodel, Float productprice, int productid,
		String productname, String categoryname,int count) {
	
	this.itemid = itemid;
	this.customerid = customerid;
	this.cartid = cartid;
	this.productmodel = productmodel;
	this.productprice = productprice;
	this.productid = productid;
	this.productname = productname;
	this.categoryname = categoryname;
	this.count=count;
}

public Cart() {
	
}

public int getItemid() {
	return itemid;
}
public void setItemid(int itemid) {
	this.itemid = itemid;
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public String getProductmodel() {
	return productmodel;
}
public void setProductmodel(String productmodel) {
	this.productmodel = productmodel;
}
public Float getProductprice() {
	return productprice;
}
public void setProductprice(Float productprice) {
	this.productprice = productprice;
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
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public String toString() {
    
    return itemid+" "+customerid+" "+cartid+" "+count;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}


}
