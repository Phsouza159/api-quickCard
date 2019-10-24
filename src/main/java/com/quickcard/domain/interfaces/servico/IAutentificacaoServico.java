package com.quickcard.domain.interfaces.servico;

import com.quickcard.domain.exception.EntityNotFoundException;

public interface IAutentificacaoServico {

    void verificarLogin(String userEmail , String userPassWord) throws EntityNotFoundException;
}
