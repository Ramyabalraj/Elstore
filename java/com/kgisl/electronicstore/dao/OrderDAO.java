package com.kgisl.electronicstore.dao;

import java.util.List;

import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.exceptionhandler.OrderException;
import com.kgisl.electronicstore.model.Cart;
import com.kgisl.electronicstore.model.Order;

public interface OrderDAO {
	public int orderInsert(int itemid,int cusid) throws NullpointerException ;
	public int orderDelete(int id,int cusid) throws OrderException;
	public int orderDeleteCart(int id) throws OrderException;
	public int orderInsertCart( int id);
	public List<Order> orderList();
	
	public List<Order> orderMapCust(int cusid) throws NullpointerException;

}
