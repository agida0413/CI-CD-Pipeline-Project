package com.yj.service;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yj.api.ResponseApi;
import com.yj.dto.JoinDTO;
import com.yj.repository.MemberRepository;
import com.yj.util.CaptchaUtil;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.gimpy.FishEyeGimpyRenderer;
import nl.captcha.text.producer.NumbersAnswerProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder encoder;
	
	public ResponseEntity<ResponseApi<?>> getCaptcha(HttpSession session) throws IOException{
	
		Captcha captcha=CaptchaUtil.getCaptchaImg();
		
		String key=UUID.randomUUID()+"[CAPTHA]:[ANSWER]"; 
		
		session.setAttribute(key, captcha.getAnswer());
	
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(captcha.getImage(),"png" , bos);
		String image = Base64.getEncoder().encodeToString(bos.toByteArray());
		
		
		Map<String, String> map = new HashMap<>();
		map.put("captchaKey", key);
		map.put("captchaImage",image );
		
		log.info("captha answer={}",captcha.getAnswer());
		ResponseApi<Map> responseApi= new ResponseApi<Map>(map);
		
	
		return ResponseEntity.ok(responseApi);
	}
	
	
	public ResponseEntity<ResponseApi<?>> join (JoinDTO joinDTO,HttpSession session) throws Exception{
		String captcha=joinDTO.getCaptcha();
		String answer=(String)session.getAttribute(joinDTO.getCaptchaKey());
		if(answer==null) {
			throw new Exception("키값이 존재하지 않습니다.");
		}
		if(!answer.equals(captcha)) {
			throw new Exception("보안 문자가 틀렸습니다.");
		}
		
		String password= joinDTO.getPassword();
		password=encoder.encode(password);
		joinDTO.setPassword(password);
		
		memberRepository.join(joinDTO);
		return ResponseEntity.ok().build();
		
	}
}
