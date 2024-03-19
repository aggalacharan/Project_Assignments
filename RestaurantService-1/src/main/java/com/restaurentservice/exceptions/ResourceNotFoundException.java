package com.restaurentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String filedName;
	private long filedvalue;
	
	public ResourceNotFoundException(String resourceName,String filedName,long filedvalue){
		super(String.format("%s not found with %s :'%s'",resourceName,filedName,filedvalue));
		this.resourceName=resourceName;
		this.filedName=filedName;
		this.filedvalue=filedvalue;
		
		
	}
	
	
	
	

}
