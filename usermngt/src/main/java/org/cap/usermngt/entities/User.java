package org.cap.usermngt.entities;

import java.math.BigInteger;
import javax.persistence.*;

@Entity
@Table(name = "userdetails")
public class User {

	@Id
	@GeneratedValue
	private BigInteger userId;

	private String userType;

	private String userName;

	private String userPassword;

	private BigInteger userPhone;

	private String userEmail;

	public User() {
		super();
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

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

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || !(object instanceof User))
			return false;
		User user = (User) object;
		return this.userId.equals(user.userId);
	}

	@Override
	public int hashCode() {
		return userId.hashCode();
	}
	
	

}
