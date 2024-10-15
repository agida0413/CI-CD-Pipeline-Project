package com.yj.security.user;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yj.dto.MemberDTO;
import com.yj.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{
private final MemberRepository repository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		//시큐리티 진행을 위해 해당이메일을 가진 회원정보를 가져옴 
		MemberDTO dto=repository.findByUsername(username);
		
		
		//이메일 기반 회원이 있다면 
		if(dto!=null) {

			
			return new CustomUserDetails(dto);
		}
		//없을경우 null 리턴
		return null;
	}

}