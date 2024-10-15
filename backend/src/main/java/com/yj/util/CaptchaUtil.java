package com.yj.util;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.http.ResponseEntity;

import com.yj.api.ResponseApi;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.gimpy.FishEyeGimpyRenderer;
import nl.captcha.text.producer.NumbersAnswerProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;

public class CaptchaUtil {

	private static final int width = 270;
	private static final int height=54;
	
	public static Captcha getCaptchaImg() {
		List<Font> fontList=new ArrayList<>();
		//fontList.add(new Font("",Font.HANGING_BASELINE,40));
		fontList.add(new Font("Courier",Font.ITALIC,40));
		//fontList.add(new Font("",Font.PLAIN,40));
		
		List<Color> colorList = new ArrayList<>();
		colorList.add(Color.blue);
		Captcha captcha=  new Captcha.Builder(270, 54)
				.addText(new NumbersAnswerProducer(6),new DefaultWordRenderer(colorList,fontList))
				.addNoise()
				.addBackground(new GradiatedBackgroundProducer())
				.gimp(new FishEyeGimpyRenderer())
				.build();
		
		return captcha;
	}
}
