package com.kgisl.electronicstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kgisl.electronicstore.dao.LoginDAO;
import com.kgisl.electronicstore.model.Login;

public class LoginDAOimpl implements LoginDAO{
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*
	 * select the category name from the category table in database and add the
	 * category name in the listCategory using RowMapper and return the listCategory
	 */

	
	public int getAllLogin(Login login) {
		
		String sql = "SELECT * FROM login ";
	
		List<Login> listLogin = template.query(sql, new RowMapper<Login>() {
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				Login p = new Login();
				p.setCustomerid(rs.getInt("customerid"));
				p.setUsername(rs.getString("username"));
				p.setAddress(rs.getString("address"));
				p.setPassword(rs.getString("password"));
				p.setPhoneno(rs.getInt("phoneno"));
				
				return p;
			
			}
			   
		});
		
		
	  int gid = 0;
			    for(Login a:listLogin) { 
		      
			    	int  count=0;
			    	
			    	
		           if(login.getUsername().equals(a.getUsername())&&login.getPassword().equals(a.getPassword())){
		      	gid=a.getCustomerid();
		        	
		    
		       }else{
		    	 
		    	  count= count+1;
		    	 
		    	  if(count>listLogin.size()-1){
		    		  System.out.println();
		    	   }
		       }
		          
		        	  
		        };  

		    	return gid;

		
	}

	public List<Login> getCustomerId(int cusid) {
		String sql = "SELECT * FROM login where customerid='"+cusid+"' ";
		
		List<Login> listLogin = template.query(sql, new RowMapper<Login>() {
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Login p = new Login();
				p.setCustomerid(rs.getInt("customerid"));
				p.setUsername(rs.getString("username"));
				p.setAddress(rs.getString("address"));
				p.setPassword(rs.getString("password"));
				p.setPhoneno(rs.getInt("phoneno"));
			
				return p;
			
			}

		});

		return listLogin;

	}


}
