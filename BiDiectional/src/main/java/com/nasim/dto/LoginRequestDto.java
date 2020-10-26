package com.nasim.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequestDto {
	@NotBlank(message = "Username mandatory")
    private String username;
    @NotBlank(message = "Password mandatory")
    private String password;
}
