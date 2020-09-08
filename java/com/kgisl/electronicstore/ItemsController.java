package com.kgisl.electronicstore;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kgisl.electronicstore.dao.ItemsDAO;
import com.kgisl.electronicstore.exceptionhandler.ItemsException;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Items;
@Controller
@RequestMapping("/item")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemsController {
	/*
	 * @author nivetha
	 * @author aarthi
	 * @since 2,jan,2020
	 */
	@Autowired
	ItemsDAO itemsDAO; // will inject itm from XML file


	/*
	 * GET method 
	 * Desc: To get all items
	 */
	@RequestMapping
	public @ResponseBody List<Items> itemGetAll() {
		List<Items> listItems = itemsDAO.itemsList();

		return listItems;
	}

	/*
	 * POST method 
	 * Desc: To insert a itemid,productmodel,productprice,productid
	 */
	@RequestMapping( method = RequestMethod.POST)
	public @ResponseBody List<Items> itemInsert(@RequestBody Items items) throws NullpointerException {
		itemsDAO.itemsInsert(items);
		List<Items> listItems = itemGetAll();

		return listItems;
		
	}

	/*
	 * GET method 
	 * Desc: To delete a itemid,productmodel,productprice,productid
	 * Input:itemid
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody List<Items> itemDelete(@PathVariable int id) throws ItemsException, NullpointerException {

	
		itemsDAO.itemsDelete(id);
		List<Items> listItems = itemGetAll();

		return listItems;
		

	}

	/*
	 * GET method 
	 * Desc: To get a itemid,productmodel,productprice,productid
	 * Input:itemid
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Items> itemGetById(@PathVariable int id) throws ItemsException, SQLException {

				return 	 itemsDAO.itemsGetById(id);

	}
	/*
	 * POST method 
	 * Desc: To update a itemid,productmodel,productprice,productid
	 */

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody List<Items> itemUpdate(@RequestBody Items items) throws NullpointerException {
		itemsDAO.itemsUpdate(items);
		List<Items> listItems = itemGetAll();

		return listItems;
		
	}

	/*
	 * GET method 
	 * Desc: To map a category&product&items table
	 * Input:productmodel
	 */
	@RequestMapping(value = "/mapcategory/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Items> itemsMapByCategory(@PathVariable int id) throws ItemsException {
		List<Items> listmap = itemsDAO.itemsMapByCategory(id);

		return listmap;
	}
	
	@RequestMapping(value = "/mapbyid/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Items> itemMapall(@PathVariable int id) throws ItemsException {
		List<Items> listmap = itemsDAO.itemsMapall(id);

		return listmap;
	}
	
	
	
	
	
}
