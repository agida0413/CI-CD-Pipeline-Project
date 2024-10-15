package com.yj.repository.impl;

import org.springframework.stereotype.Repository;

import com.yj.dto.JoinDTO;
import com.yj.dto.MemberDTO;
import com.yj.mapper.MemberMapper;
import com.yj.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class MybatisMemberRepository implements MemberRepository{

	private final MemberMapper mapper;
	
	@Override
	public void join(JoinDTO dto) {
		// TODO Auto-generated method stub
		
		mapper.join(dto);
	}

	@Override
	public MemberDTO findByUsername(String username) {
		// TODO Auto-generated method stub
		return mapper.findByUsername(username);
	}

}
