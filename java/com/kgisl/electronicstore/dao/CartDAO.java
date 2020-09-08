package com.kgisl.electronicstore.dao;

import java.util.List;

import com.kgisl.electronicstore.exceptionhandler.CartException;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Cart;



public interface CartDAO{
	
	public void  cartInsert(int id,int cusid) throws NullpointerException ;
	public void cartDelete(int id,int cusid) throws CartException;
public  List<Cart>  cartMap(int cusid) throws NullpointerException;
	public List<Cart> cartList();
	
}
