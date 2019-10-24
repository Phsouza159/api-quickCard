package com.quickcard.domain.interfaces.servico;

import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IEntidadeBasica;

import java.util.List;

public interface  IBasicCrud <ITenty extends IEntidadeBasica> {

    List<ITenty> getAll (String idEstudante)                          throws EntityNotFoundException;
    ITenty getById      (String idEstudante , String idCartaoMemoria) throws EntityNotFoundException;
    void add            (ITenty entity , String idEstudante)          throws EntityNotFoundException;
    void update         (ITenty entity , String idEstudante )         throws EntityNotFoundException;
    void delete         (ITenty entity , String idEstudante )         throws EntityNotFoundException;

}
