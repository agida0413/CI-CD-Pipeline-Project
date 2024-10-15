package com.yj.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.yj.api.ResponseApi;
import com.yj.dto.JoinDTO;

import jakarta.servlet.http.HttpSession;

public interface MemberService {
	public ResponseEntity<ResponseApi<?>> getCaptcha(HttpSession session) throws IOException;
	public ResponseEntity<ResponseApi<?>> join (JoinDTO joinDTO,HttpSession session) throws Exception;
}
