
package com.kgisl.electronicstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgisl.electronicstore.dao.CartDAO;
import com.kgisl.electronicstore.exceptionhandler.CartException;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Cart;


/*
 * @author nivetha
 * @author aarthi
 * @since 4,jan,2020
 */
@Controller
@RequestMapping("/cart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
	
	@Autowired
	CartDAO cartDAO;

	/*
	 * GET method 
	 * Desc: To get all cartid,customerid,itemid
	 */
	@RequestMapping
	public @ResponseBody List<Cart> cartGetAll() {
		List<Cart> listCart = cartDAO.cartList();

		return listCart;
	}

	/*
	 * POST method 
	 * Desc: To  insert a cartid,customerid,itemid
	 */

	@RequestMapping(value = "/{id}/{cusid}", method = RequestMethod.POST)

	public @ResponseBody List<Cart> cartInsert(@PathVariable int id, @PathVariable int cusid) throws NullpointerException {
		cartDAO.cartInsert(id, cusid);
		List<Cart> listCart = cartGetAll();

		return listCart;
			}
	/*
	 * GET method 
	 * Desc: To  delete a cartid,customerid,itemid
	 * Input:itemid,customerid
	 */

	@RequestMapping(value = "/{id}/{cusid}", method = RequestMethod.DELETE)
	public @ResponseBody List<Cart> cartDelete(@PathVariable int id, @PathVariable int cusid) throws CartException {
		
		cartDAO.cartDelete(id, cusid);
				
		List<Cart> listCart = cartGetAll();

		return listCart;
	}
	/*
	 * GET method 
	 * Desc: To  map a category&product&item&cart table
	 * Input:itemid
	 */

	@RequestMapping(value = "/{cusid}", method = RequestMethod.GET)
	public @ResponseBody List<Cart> cartMapping(@PathVariable int cusid) throws NullpointerException {
		List<Cart> listItemsmap = cartDAO.cartMap(cusid);

		return listItemsmap;
	}

}
