package com.yj.repository;

import com.yj.dto.JoinDTO;
import com.yj.dto.MemberDTO;

public interface MemberRepository {

	public void join(JoinDTO dto);
	public MemberDTO findByUsername(String username);
}
