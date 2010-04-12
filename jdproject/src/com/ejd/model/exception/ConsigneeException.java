package com.ejd.model.exception;

public class ConsigneeException extends Exception {
	public ConsigneeException(){
		super();
	}
	public ConsigneeException(String msg){
		super(msg);
	}
	public ConsigneeException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
