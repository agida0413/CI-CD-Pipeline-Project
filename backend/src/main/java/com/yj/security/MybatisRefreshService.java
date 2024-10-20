package com.yj.security;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.yj.api.ResponseApi;
import com.yj.dto.TokenStoreDTO;
import com.yj.repository.JwtRepository;
import com.yj.security.jwt.JWTUtil;
import com.yj.util.CookieUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MybatisRefreshService implements RefreshService{
	
	private final JwtRepository repository;
	private final JWTUtil jwtUtil;


	// 데이터베이스에서 리프레시 토큰을 지움 매개변수는 토큰 			
	public	void deleteRefresh(String refresh) {
			repository.deleteRefresh(refresh);
		}
		
		
	public void addRefreshEntity(String username,String refresh, Long expiredMs,HttpServletRequest request) {// 리프레시토큰을 데이터베이스에 저장
				
		    Date date = new Date(System.currentTimeMillis() + expiredMs); //현재시간 + 매개변수로 받은 유효기간 
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String formattedDate = sdf.format(date);

		    TokenStoreDTO dto= new TokenStoreDTO();

		    dto.setRefresh(refresh); // 매개변수로 받은 토큰 
		    dto.setExpiration(formattedDate); // 유효기간
		    dto.setUsername(username);
		    repository.save(dto);//데이터에 저장
	}
	
	public Boolean	isExist(String refresh) { //리프레시 토큰이 데이터베이스에 실존하는지 검증
		
		int count=repository.findRefresh(refresh); //리프레시 토큰을 기준으로 데이터베이스의 행의개수
		boolean result=false;//초기값 false
		
		if(count>0) {//검색결과가 있을 시
			result=true; //true로 초기화
		}
		return result;
	}
	
	//최종 refresh 토큰 발급 서비스
	 public ResponseEntity<ResponseApi<?>> reissue(HttpServletRequest request, HttpServletResponse response) { 
	    
	     
	        String refresh = null;
	       try {
	    	  refresh=(String)CookieUtil.getCookie("refresh", request);

		} catch (Exception e) {
			// TODO: handle exception
			;
		
			return ResponseEntity.badRequest().body(new ResponseApi<Void>("만료된 인증",400));
		}
	     
	        if (refresh == null) {//만약 refresh가 없다면 

	           
	        	return ResponseEntity.badRequest().body(new ResponseApi<Void>("만료된 인증",400));
	        }

	       
	        try {
	            jwtUtil.isExpired(refresh);// 유효기간 검증 
	        } catch (ExpiredJwtException e) {
	        	
	        	response.addCookie(CookieUtil.deleteRefreshCookie());//refresh 쿠키제거메서드
	        	return ResponseEntity.badRequest().body(new ResponseApi<Void>("만료된 인증",400));
	        }

	      
	        String category = jwtUtil.getCategory(refresh);   // 토큰이 refresh인지 확인 (발급시 페이로드에 명시)

	        if (!category.equals("refresh")) {//refresh 토큰이 아니면 

	         
	        	return ResponseEntity.badRequest().body(new ResponseApi<Void>("만료된 인증",400));
	        }
	        
	       
			Boolean isExist = isExist(refresh); //DB에 저장되어 있는지 확인
			if (!isExist) {//없다면 
			
				  response.addCookie(CookieUtil.deleteRefreshCookie());//refresh 쿠키제거메서드
				  return ResponseEntity.badRequest().body(new ResponseApi<Void>("만료된 인증",400));
			}
	        

	        String username = jwtUtil.getUsername(refresh); //토큰에서 이메일을 읽어옴

	        //새로운 jwt 토큰 발급 
	        String newAccess = jwtUtil.createJwt("access", username, 300000L);
	        String newRefresh = jwtUtil.createJwt("refresh", username,86400000L);

	        
	     	        
			deleteRefresh(refresh); //Refresh 토큰 저장 DB에 기존의 Refresh 토큰 삭제 후 새 Refresh 토큰 저장
			
			 
			addRefreshEntity(username, newRefresh, 86400000L,request);//새 토큰 데이터에 저장
	        
	        response.setHeader("access", newAccess); //새로운 토큰을 헤더에 추가 
	        
	        response.addCookie(CookieUtil.createCookie("refresh", newRefresh)); // 쿠키생성 메서드

	        return ResponseEntity.ok(new ResponseApi<Void>());
	    }
	
	

}