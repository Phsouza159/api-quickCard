package com.quickcard.model;

import com.quickcard.config.JwtTokenUtil;

import java.io.Serializable;
import java.util.Date;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String id;
	private final String status;
	private final String jwttoken;
	private final Date dateAcesso;
	private final Date dateExpired;
	private final String userName;

	public JwtResponse(String jwttoken , String userName , String id) {
		this.jwttoken = jwttoken;
		this.userName = userName;
		this.id	= id;
		this.dateAcesso = new Date();
		this.dateExpired = new Date(System.currentTimeMillis() + JwtTokenUtil.JWT_TOKEN_VALIDITY*1000);
		this.status = "ok";
	}

	public String getToken() {
		return this.jwttoken;
	}
}