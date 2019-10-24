package com.quickcard.domain.interfaces.servico;

import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IEstudante;

import java.util.List;

public interface IEstudanteServico {

    IEstudante getByEmail(String email) throws EntityNotFoundException;

    List<IEstudante> getAll() throws EntityNotFoundException;

    IEstudante getById(String id)  throws EntityNotFoundException;

    void add(IEstudante responseEntity);

    void update(IEstudante estudanteEntity);
}
