package com.quickcard.service;

import com.quickcard.domain.exception.EntityNotFoundException;
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
    public List<ICartaoMemoria> getAll(String idEstudante) throws EntityNotFoundException {
        List<ICartaoMemoria> response = new ArrayList<ICartaoMemoria>();
        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);
        try{

            if(estudanteEntity != null) {
                for(IBlocoCartao blocoCartao : estudanteEntity.getBlocoCartao()) {
                    for ( ICartaoMemoria cartaoMemoria :  blocoCartao.getCartaoMemoria()) {
                        response.add(cartaoMemoria);
                    }
                }
                return response;
            }
            return null;

        }catch(NullPointerException err) {

            return null;
        }
    }

    @Override
    public ICartaoMemoria getById(String idEstudante, String idCartaoMemoria) throws EntityNotFoundException {

        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        if(estudanteEntity != null) {
            for(IBlocoCartao blocoCartao : estudanteEntity.getBlocoCartao()) {
                for ( ICartaoMemoria cartaoMemoria :  blocoCartao.getCartaoMemoria()) {

                    if(cartaoMemoria.getId().toString().equals(idCartaoMemoria)) {
                        return cartaoMemoria;
                    }
                }
            }
        }

        throw new EntityNotFoundException("A entidade cartao memoria correspondente ao id " + idCartaoMemoria + "não foi localizada");
    }

    public ICartaoMemoria getById(IEstudante estudanteEntity, String idCartaoMemoria) throws EntityNotFoundException {
        for(IBlocoCartao blocoCartao : estudanteEntity.getBlocoCartao()) {
            for ( ICartaoMemoria cartaoMemoria :  blocoCartao.getCartaoMemoria()) {

                if(cartaoMemoria.getId().toString().equals(idCartaoMemoria)) {
                    return cartaoMemoria;
                }
            }
        }

        throw new EntityNotFoundException("A entidade cartao memoria correspondente ao id " + idCartaoMemoria + "não foi localizada");
    }

    @Override
    public void add(ICartaoMemoria entity, String idEstudante, String idBlocoCartao) throws EntityNotFoundException {

        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        IBlocoCartao  blocoCartao = estudanteEntity.getBlocoCartao( UUID.fromString(idBlocoCartao));

        entity.setId( UUID.randomUUID() );

        blocoCartao.addCartaoMemoria(entity);

        this._estudanteServico.update(estudanteEntity);
    }

    @Override
    public void update(ICartaoMemoria entity, String idEstudante) throws EntityNotFoundException {
        String idCartaoMemoria = entity.getId().toString();
        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        ICartaoMemoria cartaoMemoriaBase = this.getById(estudanteEntity , idCartaoMemoria);

        cartaoMemoriaBase.setFrenteCartao(entity.getFrenteCartao());
        cartaoMemoriaBase.setVersoCartao(entity.getVersoCartao());

        cartaoMemoriaBase.setAcertoFacil(entity.getAcertoFacil());
        cartaoMemoriaBase.setAcertoMedio(entity.getAcertoMedio());

        cartaoMemoriaBase.setDataVisualizacao(entity.getDataVisualizacao());
        cartaoMemoriaBase.setTimeVisualizacao(entity.getTimeVisualizacao());

        this._estudanteServico.update(estudanteEntity);
    }

    @Override
    public void delete(ICartaoMemoria entity, String idEstudante) throws EntityNotFoundException {

        String idCartaoMemoria = entity.getId().toString();
        IEstudante estudanteEntity = this._estudanteServico.getById(idEstudante);

        for(IBlocoCartao blocoCartao : estudanteEntity.getBlocoCartao()) {
            for ( ICartaoMemoria cartaoMemoria :  blocoCartao.getCartaoMemoria()) {

                if(cartaoMemoria.getId().toString().equals(idCartaoMemoria)) {

                    blocoCartao.removeItemCartaoMemoria(cartaoMemoria);

                    this._estudanteServico.update(estudanteEntity);
                    return;
                }
            }
        }
    }

}
