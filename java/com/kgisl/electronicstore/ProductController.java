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

import com.kgisl.electronicstore.dao.ProductDAO;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.exceptionhandler.ProductException;
import com.kgisl.electronicstore.model.Product;



/*
 * @author nivetha
 * @author aarthi
 * @since 30,dec,2019
 */
@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	@Autowired
	ProductDAO productDAO; // will inject pro from XML file
	/*
	 * GET method 
	 * Desc: To getall a productname
	 */
	

	@RequestMapping
	public @ResponseBody List<Product> productGetAll() {
		List<Product> listProduct = productDAO.productList();
		return listProduct;
	}

	/*
	 * POST method 
	 * Desc: To insert a productname,productid,categoryid
	 */
	@RequestMapping( method = RequestMethod.POST)
	
	public @ResponseBody List<Product> productInsert(@RequestBody Product product) throws NullpointerException {

		productDAO.productInsert(product);
		List<Product> listProduct = productGetAll();
		return listProduct; 
	}

	/*
	 * POST method 
	 * Desc: To delete a productname,productid,categoryid
	 * Input:productid
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<Product> productDelete(@PathVariable int id) throws ProductException {
		
		productDAO.productDelete(id);
		List<Product> listProduct = productGetAll();
		return listProduct; 


	}

	/*
	 * GET method 
	 * Desc: To get a productname,productid,categoryid
	 * Input:productid
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Product> productGetById(@PathVariable int id) throws ProductException {

		
				List<Product> productgetbyid = productDAO.productGetById(id);

				return productgetbyid;

			}
	

	/*
	 * POST method 
	 * Desc: To update a productname,productid,categoryid
	 */
	@RequestMapping( method = RequestMethod.PUT)
	public @ResponseBody List<Product> productUpdate(@RequestBody Product product) throws NullpointerException {
	
		productDAO.productUpdate(product);
		List<Product> listProduct = productGetAll();
		return listProduct; 

	}


	
}
