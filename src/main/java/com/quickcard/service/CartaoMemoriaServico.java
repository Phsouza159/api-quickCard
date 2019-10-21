package com.quickcard.service;

import com.quickcard.domain.interfaces.entidade.IBlocoAnotacao;
import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.ICartaoMemoriaServico;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CartaoMemoriaServico extends ServicoBasico implements ICartaoMemoriaServico {

    private IEstudanteServico _estudanteServico;

    @Autowired
    public CartaoMemoriaServico(IEstudanteServico estudanteServico) {
        super();

        this._estudanteServico = estudanteServico;
    }

    @Override
    public List<ICartaoMemoria> getAll(String idEstudante) {
        List<ICartaoMemoria> response = new ArrayList<ICartaoMemoria>();
        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        if(estudanteEntity != null) {
            for(IBlocoCartao blocoCartao : estudanteEntity.getBlocoCartao()) {
                for ( ICartaoMemoria cartaoMemoria :  blocoCartao.getCartaoMemoria()) {
                        response.add(cartaoMemoria);
                }
            }
            return response;
        }
        return null;
    }

    @Override
    public ICartaoMemoria getById(String idEstudante, String idCartaoMemoria) {
        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        if(estudanteEntity != null) {
            for(IBlocoCartao blocoCartao : estudanteEntity.getBlocoCartao()) {
                for ( ICartaoMemoria cartaoMemoria :  blocoCartao.getCartaoMemoria()) {

                    if(cartaoMemoria.getId().equals(idCartaoMemoria)) {
                        return cartaoMemoria;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void add(ICartaoMemoria entity, String idEstudante, String idBlocoCartao) {
        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        if(estudanteEntity != null) {
            IBlocoCartao  blocoCartao = estudanteEntity.getBlocoCartao( UUID.fromString(idBlocoCartao));

            entity.setId( UUID.randomUUID() );

            blocoCartao.addCartaoMemoria(entity);

            this._estudanteServico.update(estudanteEntity);
        }
    }

    @Override
    public void update(ICartaoMemoria entity, String idEstudante) {
        String idCartaoMemoria = entity.getId().toString();
        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        if(estudanteEntity != null) {
            for(IBlocoCartao blocoCartao : estudanteEntity.getBlocoCartao()) {
                for ( ICartaoMemoria cartaoMemoria :  blocoCartao.getCartaoMemoria()) {

                    if(cartaoMemoria.getId().equals(idCartaoMemoria)) {

                        this.mapper.map( entity , cartaoMemoria);
                        this._estudanteServico.update(estudanteEntity);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void delete(ICartaoMemoria entity, String idEstudante) {
    }
}
