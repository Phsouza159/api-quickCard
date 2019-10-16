package com.quickcard.controller;

import java.util.Objects;

import com.quickcard.domain.interfaces.servico.IAutentificacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quickcard.config.JwtTokenUtil;
import com.quickcard.model.JwtRequest;
import com.quickcard.model.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController extends ControllerBasic {

	@Autowired
	private IAutentificacaoServico authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		this.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		String userName = jwtTokenUtil.getUsernameFromToken(token);

		return ResponseEntity.ok( this.serializar(new JwtResponse(token , userName)));
	}

	private void authenticate(String userEmail, String password) throws Exception {
		Objects.requireNonNull(userEmail);
		Objects.requireNonNull(password);

		try {
			authenticationManager.verificarLogin(userEmail, password);

		} catch (BadCredentialsException e) {

			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
