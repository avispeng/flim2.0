package com.orangedietc.flim.po;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsersCustom extends Users {
	
    @NotBlank(message="password must not be empty")
    @Size(min=6, max=20, message="size of password must be between 6 and 20")
    @Pattern(regexp = "\\S+", message="password can contain a-z, A-Z, 0-9, special characters")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
