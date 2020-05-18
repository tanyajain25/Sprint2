package org.cap.usermngt.dto;

import java.math.BigInteger;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RequestUserDto {

	private String userType;
	private String userName;
	private String userPassword;
	@Min(value = 999999999L)
	@Max(value = 9999999999L)
	private BigInteger userPhone;
	private String userEmail;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigInteger getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
