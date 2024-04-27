package com.huyBui.quanLyHocSinh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.huyBui.quanLyHocSinh.API.outPut.apiResponse;
import com.huyBui.quanLyHocSinh.enums.errorCode;

@ControllerAdvice
public class GlobalExceptionHandler {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	public ResponseEntity<apiResponse> handleRuntimeException(RuntimeException runtimeException) {
		apiResponse apiResponse = new apiResponse();

		apiResponse.setCode(errorCode.UNCATEGORYZED_EXCEPTION.getCode());
		apiResponse.setMessage(errorCode.UNCATEGORYZED_EXCEPTION.getMessage());

		return ResponseEntity.badRequest().body(apiResponse);
	}

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(AppException.class)
	public ResponseEntity<apiResponse> handleAppException(AppException appException) {
		errorCode errorCode = appException.getErrorCode();

		apiResponse apiResponse = new apiResponse();

		apiResponse.setCode(errorCode.getCode());
		apiResponse.setMessage(errorCode.getMessage());

		return ResponseEntity.badRequest().body(apiResponse);

	}

	@SuppressWarnings("rawtypes")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class) // bắt ngoại lệ tất cả các method của các class
	public ResponseEntity<apiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

		String enumKey = ex.getFieldError().getDefaultMessage();
		errorCode error = errorCode.valueOf(enumKey);

		apiResponse apiResponse = new apiResponse();

		apiResponse.setCode(error.getCode());
		apiResponse.setMessage(error.getMessage());

		return ResponseEntity.badRequest().body(apiResponse);

	}
}
