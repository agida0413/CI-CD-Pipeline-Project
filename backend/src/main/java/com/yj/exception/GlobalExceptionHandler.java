package com.yj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yj.api.ResponseApi;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	
	 // 기타 예기치 못한 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseApi<?>> handlevalid(MethodArgumentNotValidException ex) {
        log.error("Exception: {}", ex.getMessage(), ex);

        ResponseApi<Void> responseApi= new ResponseApi<>("유효하지 않은 입력입니다.", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.internalServerError().body(responseApi);
    }
	
	  // 기타 예기치 못한 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi<?>> handleGenericException(Exception ex) {
        log.error("Exception: {}", ex.getMessage(), ex);

        ResponseApi<Void> responseApi= new ResponseApi<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(responseApi);
    }
    
    
   
    
    
}
