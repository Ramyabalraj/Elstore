package com.kgisl.electronicstore.model;

public class Category {
	 private int categoryid;
	 private String categoryname;
	
	 public Category(int categoryid,String categoryname) {
		this.categoryid=categoryid;
		this.categoryname=categoryname;
		
	}
	 public Category(String categoryname) {
		 this.categoryname=categoryname;
	 }
	 public Category() {
		 
	 }
	public int getCategoryid() {
		return categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
public String toString() {
        
        return String.format(categoryname);
    }
	

}
