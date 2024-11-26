package com.hexaware.fastx.payload;

public class JWTAuthResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private Object userDetails;//appending user details and JWT Token in response
	public JWTAuthResponse() {	}
	public JWTAuthResponse(String accessToken, Object userDetails) {
		super();
		this.accessToken = accessToken;
		this.userDetails = userDetails;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public Object getUserDto() {
		return userDetails;
	}
	public void setUserDto(Object userDetails) {
		this.userDetails = userDetails;
	}}