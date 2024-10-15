package com.yj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yj.dto.JoinDTO;
import com.yj.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public void join(JoinDTO dto);
	public MemberDTO findByUsername(String username);
}
