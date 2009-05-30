package com.ejd.model.exception;

public class ProductException extends Exception {
	public ProductException(){
		super();
	}
	public ProductException(String msg){
		super(msg);
	}
	public ProductException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
