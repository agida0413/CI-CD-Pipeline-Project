package com.yj.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JoinDTO {
	
	@Size(min = 6,max = 15)
	private String username;
	
	
	@Size(min=8,max = 20)
	private String password;
	
	@NotBlank(message = "값이 필요합니다.")
	@Pattern(regexp = "^[^\\s]+$", message = "공백이 포함될 수 없습니다.")
	private String name;
	
	@NotBlank(message = "값이 필요합니다.")
	@Pattern(regexp = "^[^\\s]+$", message = "공백이 포함될 수 없습니다.")
	private String captcha;
	
	@NotBlank(message = "값이 필요합니다.")
	@Pattern(regexp = "^[^\\s]+$", message = "공백이 포함될 수 없습니다.")
	private String captchaKey;
}
