package com.kgisl.electronicstore.dao;
import java.util.List;
import com.kgisl.electronicstore.model.Login;
public interface LoginDAO {
		public int getAllLogin(Login login);
		public List<Login> getCustomerId(int cusid);
		
		
	}


