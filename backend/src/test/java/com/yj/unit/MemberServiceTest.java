package com.yj.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mysql.cj.Session;
import com.yj.api.ResponseApi;
import com.yj.dto.JoinDTO;
import com.yj.dto.MemberDTO;
import com.yj.repository.MemberRepository;
import com.yj.repository.impl.MybatisMemberRepository;
import com.yj.service.MemberService;
import com.yj.service.MemberServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	@InjectMocks
	private MemberServiceImpl memberService;

	@Mock
	private MybatisMemberRepository memberRepository;
	@Mock
	private BCryptPasswordEncoder encoder;

	@Test
	public void joinTest() throws Exception {
	   memberRepository.findByUsername("test");
	
	}
}
