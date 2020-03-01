package com.codeseeker.microUserService.ui.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Users")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7894268286556320158L;
	@Id
	@GeneratedValue(generator = "userid")
	@GenericGenerator(name = "userid", strategy = "com.codeseeker.microUserService.internals.idgenerator.GenericUserIDGenerator")
	private String userid;
	@Column(nullable = false, length = 50)
	private String firstname;
	@Column(nullable = false, length = 50)
	private String lastname;
	@Column(nullable = false, length = 100, unique = true)
	private String email;
	@Column(nullable = false, length = 500)
	private String encryptedpassword;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedpassword() {
		return encryptedpassword;
	}

	public void setEncryptedpassword(String encryptedpassword) {
		this.encryptedpassword = encryptedpassword;
	}

	

}
