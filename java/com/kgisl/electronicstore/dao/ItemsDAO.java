package com.kgisl.electronicstore.dao;

import java.util.List;

import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Items;


public interface ItemsDAO {
	public List<Items> itemsList();
	public int itemsInsert(Items i) throws NullpointerException;
	public int itemsDelete(int id) throws NullpointerException;
	public List<Items> itemsGetById(int id);
	public int itemsUpdate(Items i) throws NullpointerException;
	

	
	public List<Items> itemsMapByCategory(int id);
	
	public List<Items> itemsMapall(int id);


}
