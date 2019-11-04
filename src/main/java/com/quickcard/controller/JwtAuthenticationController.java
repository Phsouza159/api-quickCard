package com.quickcard.controller;

import java.util.Objects;

import com.quickcard.config.RoutesController;
import com.quickcard.domain.entidades.Estudante;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.IAutentificacaoServico;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import com.quickcard.model.EstudanteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	private IEstudanteServico estudanteServico;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate" , method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		this.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		IEstudante estudante = estudanteServico.getByEmail(authenticationRequest.getUsername());


		final String token = jwtTokenUtil.generateToken(userDetails);
		String userName = jwtTokenUtil.getUsernameFromToken(token);

			return ResponseEntity.ok( this.serializar(new JwtResponse(token , userName , estudante.getId().toString() )));
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


	@RequestMapping(value = "/newUser" , method = RequestMethod.PUT)
	public ResponseEntity<IEstudante> post(@RequestBody EstudanteModel estudanteModel) throws Exception {

		IEstudante responseEntity = this.mapper.map(estudanteModel , Estudante.class);

		this.estudanteServico.add(responseEntity);

		return  ResponseEntity.status(HttpStatus.CREATED).body(responseEntity);
	}

}
