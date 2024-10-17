package com.yj.integrate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yj.dto.JoinDTO;
import com.yj.dto.MemberDTO;
import com.yj.repository.impl.MybatisMemberRepository;

@SpringBootTest
@Transactional
class BackendApplicationTest {

	
	
	@Autowired
	private MybatisMemberRepository repository;
	
	
	
	@Test
	public void joinTest() throws Exception {
		
		JoinDTO dto = new JoinDTO();
		dto.setName("1234");
		dto.setPassword("12341234");
		dto.setUsername("agida4132");
		
		repository.join(dto);
		
		MemberDTO findDto = repository.findByUsername("agida4132");
		
		assertThat(findDto.getUsername()).isEqualTo("agida4132");
	}

}
