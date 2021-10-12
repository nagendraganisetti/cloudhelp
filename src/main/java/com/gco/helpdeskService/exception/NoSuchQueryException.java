package com.gco.helpdeskService.exception;

public class NoSuchQueryException extends Exception {
	
	private String msg; 
	public NoSuchQueryException(String msg)
	{
		this.msg=msg;
	}
	
	@Override
	public String toString() {
		return "NoSuchQueryException [message=" + msg + "]";
	}


}