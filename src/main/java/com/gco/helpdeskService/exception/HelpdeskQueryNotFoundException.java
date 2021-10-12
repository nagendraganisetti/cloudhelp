package com.gco.helpdeskService.exception;

public class HelpdeskQueryNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public HelpdeskQueryNotFoundException(String message)
	{
		this.message=message;
	}
 //HelpdeskQueryNotFoundException
	@Override
	public String toString() {
		return "HelpdeskQueryNotFoundException [message=" + message + "]";
	}

	

}