package com.quickcard.domain.interfaces.servico;

import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IEntidadeBasica;

import java.util.List;

public interface IServicoBasico {

    String hashSenha(String senhaPura);
    <TEntity extends IEntidadeBasica> TEntity getItemCollectionById(List<TEntity> entityList , String id) throws EntityNotFoundException;
    <TEntity extends  IEntidadeBasica> List<TEntity> removeItemCollectionById(List<TEntity> entityList , String id) throws EntityNotFoundException;

}
