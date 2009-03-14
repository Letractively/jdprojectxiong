package com.ejd.model.exception;

public class ProductCategoryException extends Exception {
	public ProductCategoryException(){
		super();
	}
	public ProductCategoryException(String msg){
		super(msg);
	}
	public ProductCategoryException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
