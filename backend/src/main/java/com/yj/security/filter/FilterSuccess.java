package com.yj.security.filter;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.api.ResponseApi;

import jakarta.servlet.http.HttpServletResponse;

public class FilterSuccess {
	public static void filterSuccess(HttpServletResponse response,ObjectMapper objectMapper) throws JsonProcessingException, IOException {
		
		response.setStatus(HttpStatus.OK.value());
		response.getWriter().write(objectMapper.writeValueAsString(new ResponseApi<Void>()));
	}
}
