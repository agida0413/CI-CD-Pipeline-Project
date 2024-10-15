package com.yj.api;

import org.springframework.http.HttpStatus;

import lombok.Getter;
@Getter
public class ResponseApi<T> {

	private boolean status;
	private String message;
	private T data; 
	private int code;
	
	
public ResponseApi(String message,int code){
		this.status=false;
		this.message=message;
		this.data=null;
		this.code=code;
	}
	
public	ResponseApi(T data){
		this.status=true;
		this.code=HttpStatus.OK.value();
		this.data=data;
		
	}

public	ResponseApi(){
	this.status=true;
	this.code=HttpStatus.OK.value();
}
	
}
