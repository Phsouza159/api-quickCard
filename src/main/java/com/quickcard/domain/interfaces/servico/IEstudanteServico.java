package com.quickcard.domain.interfaces.servico;

import com.quickcard.domain.interfaces.entidade.IEstudante;

import java.util.List;

public interface IEstudanteServico {

    IEstudante getByEmail(String email);

    List<IEstudante> getAll();

    IEstudante getById(String id);

    void add(IEstudante responseEntity);
}
