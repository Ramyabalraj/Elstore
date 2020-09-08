package com.kgisl.electronicstore.exceptionhandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Product Not Found") //404
public class ProductException  extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public ProductException(int id){
//		super("CategoryNotFoundException with id="+id);

		System.out.println("vvvvvvvvvvvvvvv");
		
	}
	

}