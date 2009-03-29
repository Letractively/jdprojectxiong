package com.ejd.model.exception;

public class ProductBrandException extends Exception {
	public ProductBrandException(){
		super();
	}
	public ProductBrandException(String msg){
		super(msg);
	}
	public ProductBrandException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
