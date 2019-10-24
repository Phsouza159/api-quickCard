package com.quickcard.domain.interfaces.servico;

import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;

import java.util.List;

public interface ICartaoMemoriaServico extends IServicoBasico {

    List<ICartaoMemoria> getAll(String idEstudante) throws EntityNotFoundException;
    ICartaoMemoria getById(String idEstudante , String idCartaoMemoria) throws EntityNotFoundException;
    void add(ICartaoMemoria entity , String idEstudante , String idBlocoCartao) throws EntityNotFoundException;
    void update(ICartaoMemoria entity , String idEstudante ) throws EntityNotFoundException;
    void delete(ICartaoMemoria entity , String idEstudante );

}
