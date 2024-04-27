package com.huyBui.quanLyHocSinh.API.outPut;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) //Khai bao cho Json biet khi chuyen doi ojbect sang Json nhưng gtri null se k chen vao
public class apiResponse<T> {

	private int code = 200;
	private String message = "success";
	private T result;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	
	
}
