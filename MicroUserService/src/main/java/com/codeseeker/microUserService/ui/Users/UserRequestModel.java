package com.codeseeker.microUserService.ui.Users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequestModel {
	@NotBlank(message = "First name should not be empty.")
	@Size(min = 2, message = "Firstname should not be less than two chars.")
	private String firstname;

	@NotBlank(message = "First name should not be empty.")
	@Size(min = 2, message = "Firstname should not be less than two chars.")
	private String lastname;

	@NotBlank(message = "Password is mandatory.")
	@Size(min = 7, message = "Length of the password should be min 7 chars.")
	private String password;

	@Email(message = "Enter a valid email.")
	@NotBlank(message = "Email is required.")
	private String email;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
