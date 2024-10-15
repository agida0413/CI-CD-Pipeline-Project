package com.yj.dto;



import lombok.Data;
import lombok.Getter;

@Data
public class TokenStoreDTO {
	
private int toNum; //토큰 고유번호 
private String username;
private String refresh; //리프레시 토큰 
private String expiration; //유효기간
private String browser;
}