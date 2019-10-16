package com.quickcard.service;


import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.IAutentificacaoServico;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
public class AutentificacaoServico extends ServicoBasico implements IAutentificacaoServico {

    private IEstudanteServico _estudanteServico;

    @Autowired
    public AutentificacaoServico(IEstudanteServico estudanteServico) {

        this._estudanteServico = estudanteServico;
    }

    public void verificarLogin(String userEmail , String userPassWord) throws BadCredentialsException {

        IEstudante estudante = this._estudanteServico.getByEmail(userEmail);

        if(estudante != null) {
            if(estudante.getSenha().equals( this.hashSenha(userPassWord) )) {

                return;
            }
        }

        throw new BadCredentialsException("Credenciais inválidas!");
    }



}
