package com.ejd.model.exception;

public class CouponException extends Exception {
	public CouponException(){
		super();
	}
	public CouponException(String msg){
		super(msg);
	}
	public CouponException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
