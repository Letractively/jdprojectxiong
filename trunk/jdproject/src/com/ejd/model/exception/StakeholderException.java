package com.ejd.model.exception;

public class StakeholderException extends Exception {
	public StakeholderException(){
		super();
	}
	public StakeholderException(String msg){
		super(msg);
	}
	public StakeholderException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
