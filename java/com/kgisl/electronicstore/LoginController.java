
package com.kgisl.electronicstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgisl.electronicstore.dao.LoginDAO;
import com.kgisl.electronicstore.model.Category;
import com.kgisl.electronicstore.model.Login;


/*
 * @author nivetha
 * @author aarthi
 * @since 27,dec,2019
 */

@Controller
@RequestMapping("/login")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
	@Autowired
	LoginDAO loginDAO;// will inject dao from XML file
	

	/*
	 * GET method 
	 * Desc: To get all categoryname
	 */
	@RequestMapping( method = RequestMethod.POST)
	public @ResponseBody int getAll(@RequestBody Login login) {
		
		int listLogin = loginDAO.getAllLogin(login);
	
		return listLogin;
	}

	@RequestMapping(value = "/{cusid}", method = RequestMethod.GET)
	public @ResponseBody List<Login> getCategoryId(@PathVariable int cusid) {
		
		List<Login> listLogin = loginDAO.getCustomerId(cusid);
		
		return listLogin;
	}


	}
