package com.quickcard.model;

import com.quickcard.config.JwtTokenUtil;

import java.io.Serializable;
import java.util.Date;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final Date dateAcesso;
	private final Date dateExpired;
	private final String userName;

	public JwtResponse(String jwttoken , String userName) {
		this.jwttoken = jwttoken;
		this.userName = userName;
		this.dateAcesso = new Date();
		this.dateExpired = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY*1000);
	}

	public String getToken() {
		return this.jwttoken;
	}
}