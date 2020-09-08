
package com.kgisl.electronicstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgisl.electronicstore.dao.OrderDAO;
import com.kgisl.electronicstore.exceptionhandler.CategoryException;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.exceptionhandler.OrderException;
import com.kgisl.electronicstore.model.Order;


/*
 * @author nivetha
 * @author aarthi
 * @since 6,jan,2020
 */
@Controller
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class OrderController {
	@Autowired
	OrderDAO orderDAO; // will inject dao from XML file
	/*
	 * GET method 
	 * Desc: To  get all orderid,cartid,customerid,itemid
	 */


	@RequestMapping
	public @ResponseBody List<Order> orderGetAll() {
		List<Order> listOrder = orderDAO.orderList();

		return listOrder;
	}

	/*
	 * POST method 
	 * Desc: To  insert orderid,customerid,itemid 
	 * Input:customerid,itemid 
	 */


	@RequestMapping(value = "/{itemid}/{cusid}", method = RequestMethod.POST)

	public @ResponseBody List<Order> orderInsert(@PathVariable int itemid, @PathVariable int cusid) throws NullpointerException {
		orderDAO.orderInsert(itemid, cusid);
		List<Order> listOrder = orderGetAll();

		return listOrder;
	}

	/*
	 * GET method 
	 * Desc: To  delete orderid,customerid,itemid 
	 * Input:customerid,itemid 
	 */

	@RequestMapping(value = "/{id}/{cusid}", method = RequestMethod.DELETE)
	public @ResponseBody List<Order> orderDelete(@PathVariable int id, @PathVariable int cusid) throws OrderException {
		
		orderDAO.orderDelete(id, cusid);
		List<Order> listOrder = orderGetAll();

		return listOrder;
			
}
	/*
	 * POST method 
	 * Desc: To  insert orderid,cartid 
	 * Input:cartid 
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)

	public @ResponseBody List<Order> orderInsertCart(@PathVariable int id) {
		orderDAO.orderInsertCart(id);
		List<Order> listOrder = orderGetAll();

		return listOrder;
	}
	
	/*
	 * GET method 
	 * Desc: To  delete orderid,cartid 
	 * Input:cartid 
	 */
	@RequestMapping(value = "/{id }", method = RequestMethod.DELETE)
	public @ResponseBody List<Order> orderDeleteCart(@PathVariable int id) throws OrderException {
		List<Order> listOrder = orderDAO.orderList();
		for (Order user : listOrder) {
		
			if (user.getCartid() == (id) ) {
				orderDAO.orderDeleteCart(id);
				List<Order> listOrderGetAll = orderGetAll();

				return listOrderGetAll;
			}}
		throw new OrderException(id);
	}

	/*
	 * GET method 
	 * Desc: To  map category&product&items&order
	 * Input:customerid,itemid 
	 */
	@RequestMapping(value = "/{cusid}", method = RequestMethod.GET)
	public @ResponseBody List<Order> orderMap(@PathVariable int cusid) throws NullpointerException {
		List<Order> listItemsmap = orderDAO.orderMapCust(cusid);

		return listItemsmap;
	}

	
	
}
