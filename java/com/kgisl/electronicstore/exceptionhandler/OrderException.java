package com.kgisl.electronicstore.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "order Not Found") // 404
public class OrderException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public OrderException(int id, int cusid) {
	}

	public OrderException(int id) {

	}
}
