package net.coreApp.domain.security;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;

	private String password;


	private String name;
	
	private String auth;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name="
				+ name + ", auth=" + auth + "]";
	}

}