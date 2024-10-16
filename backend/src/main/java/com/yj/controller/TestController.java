package com.yj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/test")
public class TestController {

	@GetMapping
	@ResponseBody
	public void test() {
		System.out.println("테스트");
	}
}
