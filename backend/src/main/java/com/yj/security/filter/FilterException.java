package com.yj.security.filter;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.api.ResponseApi;

import jakarta.servlet.http.HttpServletResponse;

public class FilterException {

	public static void filterException(HttpServletResponse response,ObjectMapper objectMapper) throws JsonProcessingException, IOException {
		
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.getWriter().write(objectMapper.writeValueAsString(new ResponseApi<Void>("세션이 만료",HttpStatus.INTERNAL_SERVER_ERROR.value())));
	}
	
public static void requestRefresh(HttpServletResponse response) throws JsonProcessingException, IOException {
		
		response.setStatus(HttpStatus.TEMPORARY_REDIRECT.value());
		response.setHeader("Location", "/api/v1/member/refresh");
	
	}
}
