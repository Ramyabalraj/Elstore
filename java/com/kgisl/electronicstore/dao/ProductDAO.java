package com.kgisl.electronicstore.dao;

import java.util.List;

import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Product;

public interface ProductDAO {
	public List<Product> productList();
	public int productInsert(Product p) throws NullpointerException;
	public int productDelete(int id);
	public List<Product> productGetById(int id);
	public int productUpdate(Product p) throws NullpointerException;
	
}
