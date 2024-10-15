package com.yj.repository.impl;

import java.sql.Date;

import org.springframework.stereotype.Repository;

import com.yj.dto.TokenStoreDTO;
import com.yj.mapper.JwtMapper;
import com.yj.repository.JwtRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Repository
public class MybatisJwtRepository implements JwtRepository {
	
	private final JwtMapper mapper;
	
	//현재 전달받은 토큰을 데이터베이스에서 찾아서 있으면 반환해줌
	public int	findRefresh(String refresh) {
		return mapper.findRefresh(refresh);
	}
	// 해당 토큰을 데이터베이스에서 찾아서 삭제해줌
	public	void deleteRefresh(String refresh) {
		mapper.deleteRefresh(refresh);
	}
		// 리프레시 토근정보를 저장함
	public	void save(TokenStoreDTO dto) {
		mapper.save(dto);
	}
	
	
	

	
	
	
}