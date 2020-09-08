package com.kgisl.electronicstore.exceptionhandler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException

{

	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

//	@ExceptionHandler(SQLException.class)
//	public String handleSQLException(HttpServletRequest request, Exception ex) {
//		logger.info("SQLException Occured:: URL=" + request.getRequestURL());
//		return "sqlerror";
//	}

}
