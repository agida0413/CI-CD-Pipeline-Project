package com.yj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yj.api.ResponseApi;
import com.yj.dto.JoinDTO;
import com.yj.service.MemberService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	@PostMapping
	public ResponseEntity<ResponseApi<?>> join(@Valid JoinDTO dto,HttpSession session) throws Exception,MethodArgumentNotValidException{
		
		return service.join(dto, session);
	}
}
