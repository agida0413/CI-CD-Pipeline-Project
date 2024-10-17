package com.yj.unit;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yj.api.ResponseApi;
import com.yj.repository.MemberRepository;
import com.yj.service.MemberServiceImpl;
import com.yj.util.CaptchaUtil;

import jakarta.servlet.http.HttpSession;
import nl.captcha.Captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private BCryptPasswordEncoder encoder; // Password encoder를 모킹

    @Mock
    private HttpSession session; // HttpSession 모킹

    @InjectMocks
    private MemberServiceImpl memberService; // 서비스 인스턴스

    @Test
    public void testGetCaptcha() throws IOException {
        // 1. Captcha 객체 모킹
        Captcha mockCaptcha = mock(Captcha.class);
        when(mockCaptcha.getAnswer()).thenReturn("testAnswer");
        when(mockCaptcha.getImage()).thenReturn(new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB));

        // 2. CaptchaUtil.getCaptchaImg() 모킹
        mockStatic(CaptchaUtil.class);
        when(CaptchaUtil.getCaptchaImg()).thenReturn(mockCaptcha);

        // 3. UUID 모킹
        UUID mockUUID = UUID.randomUUID();
        String expectedKey = mockUUID + "[CAPTHA]:[ANSWER]";

        // 4. 테스트 실행
        ResponseEntity<ResponseApi<?>> responseEntity = memberService.getCaptcha(session);
        
        // 5. 검증
        verify(session).setAttribute(eq(expectedKey), eq("testAnswer")); // 세션에 answer 저장 확인

        ResponseApi<?> responseApi = responseEntity.getBody();
        assertNotNull(responseApi);

        Map<String, String> responseMap = (Map<String, String>) responseApi.getData();
        assertNotNull(responseMap);
        assertEquals(expectedKey, responseMap.get("captchaKey")); // captchaKey 검증
        assertNotNull(responseMap.get("captchaImage")); // captchaImage가 존재하는지 검증
    }
}
