package com.huyBui.quanLyHocSinh.exception;

import com.huyBui.quanLyHocSinh.enums.errorCode;

public class AppException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private errorCode errorCode;
	
	public AppException(errorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public errorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(errorCode errorCode) {
		this.errorCode = errorCode;
	}
}
