package com.kgisl.electronicstore;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgisl.electronicstore.dao.CategoryDAO;
import com.kgisl.electronicstore.exceptionhandler.CategoryException;
import com.kgisl.electronicstore.exceptionhandler.NullpointerException;
import com.kgisl.electronicstore.model.Category;


/*
 * @author nivetha
 * @author aarthi
 * @since 27,dec,2019
 */

@Controller
@RequestMapping("/category")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;// will inject dao from XML file
	

	/*
	 * GET method 
	 * Desc: To get all categoryname
	 */
	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody List<Category> getAll() {
	
		List<Category> listCategory = categoryDAO.getAllCategories();
	
		return listCategory;
	}

	/*
	 * POST method 
	 * Desc: To insert a categoryname
	 * Input: category
	 */

	@RequestMapping( method = RequestMethod.POST)

	public @ResponseBody List<Category>  insert(@RequestBody Category category) throws NullpointerException {
		categoryDAO.categoryInsert(category);
		List<Category> listCategory=getAll();
		return listCategory;
	}

	/*
	 * GET method 
	 * Desc: To delete a categoryname
	 * Input: categoryid
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public  @ResponseBody List<Category> delete(@PathVariable int id) throws CategoryException {

		categoryDAO.categoryDelete(id);
	
		List<Category> listCategory=getAll();
		return listCategory;
	}

	/*
	 * GET method 
	 * Desc: To get a categoryname
	 * Input: categoryid
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)

	public @ResponseBody List<Category> getById(@PathVariable int id, ModelMap map)
			throws CategoryException, SQLException {
		
				List<Category> listbyid = categoryDAO.getCategoryByid(id);
				return listbyid;
	}


	/*
	 * POST method 
	 * Desc: To update a categoryname
	 * Input: category
	 */

	@RequestMapping( method = RequestMethod.PUT)

	public @ResponseBody List<Category> update(@RequestBody Category category) throws NullpointerException {
		categoryDAO.categoryUpdate(category);
		List<Category> listCategory=getAll();
		return listCategory;
	}

	}
