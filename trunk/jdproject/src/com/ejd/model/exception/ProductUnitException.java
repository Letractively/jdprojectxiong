package com.ejd.model.exception;

public class ProductUnitException extends Exception {
	public ProductUnitException(){
		super();
	}
	public ProductUnitException(String msg){
		super(msg);
	}
	public ProductUnitException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
