package com.quickcard.service;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IEstudanteServico _estudanteServico;

	public JwtUserDetailsService(IEstudanteServico estudanteServico) {

		this._estudanteServico = estudanteServico;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
		try {
			IEstudante estudante = this._estudanteServico.getByEmail(username);

			if (estudante != null) {

				return new User(estudante.getEmail(), estudante.getSenha(), new ArrayList<>());
			}

			throw new UsernameNotFoundException("User not found with username: " + username);
		}catch (EntityNotFoundException err) {

			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}