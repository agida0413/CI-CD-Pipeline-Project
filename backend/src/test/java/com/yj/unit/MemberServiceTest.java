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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.Session;
import com.yj.api.ResponseApi;
import com.yj.dto.JoinDTO;
import com.yj.dto.MemberDTO;
import com.yj.dto.TokenStoreDTO;
import com.yj.mapper.JwtMapper;
import com.yj.mapper.MemberMapper;
import com.yj.repository.MemberRepository;
import com.yj.repository.impl.MybatisJwtRepository;
import com.yj.repository.impl.MybatisMemberRepository;
import com.yj.service.MemberService;
import com.yj.service.MemberServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired
	private MybatisJwtRepository repository;
	
	
	
	@Test
	public void joinTest() throws Exception {
	
		TokenStoreDTO dto= new TokenStoreDTO();
		dto.setRefresh("asd");
		dto.setUsername("asd");
		dto.setExpiration("asd");
		
		repository.save(dto);
		
		int count=	repository.findRefresh("asd");
		
		assertThat(count).isEqualTo(1);
	
	}
}
