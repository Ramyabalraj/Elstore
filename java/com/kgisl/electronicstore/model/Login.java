package com.kgisl.electronicstore.model;

public class Login {
private int customerid;
private String username;
private String password;
private String address;
private int phoneno;
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPhoneno() {
	return phoneno;
}
public void setPhoneno(int phoneno) {
	this.phoneno = phoneno;
}
public Login() {
	// TODO Auto-generated constructor stub
}
public Login(int customerid, String username, String password, String address, int phoneno) {

	this.customerid = customerid;
	this.username = username;
	this.password = password;
	this.address = address;
	this.phoneno = phoneno;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return customerid+" "+username+" "+" "+password+" "+address+" "+phoneno;
}
}