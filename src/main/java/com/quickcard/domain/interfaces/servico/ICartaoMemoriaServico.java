package com.quickcard.domain.interfaces.servico;

import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;

import java.util.List;

public interface ICartaoMemoriaServico extends IServicoBasico {

    List<ICartaoMemoria> getAll(String idEstudante);
    ICartaoMemoria getById(String idEstudante , String idCartaoMemoria);
    void add(ICartaoMemoria entity , String idEstudante , String idBlocoCartao);
    void update(ICartaoMemoria entity , String idEstudante );
    void delete(ICartaoMemoria entity , String idEstudante );

}
