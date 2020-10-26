package com.nasim.dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class UserDto {
	@NotBlank
	@Size(min=4,max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotEmpty(message = "Phone Number is Mandatory")
   // @Pattern(regexp = "^(?:\\+?88)?01[1345-9]\\d{8}$", message = "invalid mobile number.")
    @Size(min=11,max = 11, message = "digits should be 11")
	private String phoneNumber;

	@NotBlank
	@Size(max = 120)
	private String password;

	   private Set<String> role;
}
