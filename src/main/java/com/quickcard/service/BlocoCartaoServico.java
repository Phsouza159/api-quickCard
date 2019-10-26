package com.quickcard.service;

import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.IBlocoCartaoServico;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlocoCartaoServico extends ServicoBasico implements IBlocoCartaoServico {

    @Autowired
    private IEstudanteServico _estudanteServico;

    @Autowired
    public BlocoCartaoServico(IEstudanteServico estudanteServico) {

        this._estudanteServico = estudanteServico;
    }

    @Override
    public List<IBlocoCartao> getAll(String idEstudante)  throws EntityNotFoundException {

        IEstudante estudante = this._estudanteServico.getById(idEstudante);

        return estudante.getBlocoCartao();
    }

    @Override
    public IBlocoCartao getById(String idEstudante, String idBlocoCartao) throws EntityNotFoundException {

        IEstudante estudante = this._estudanteServico.getById(idEstudante);

        return this.getItemCollectionById( estudante.getBlocoCartao() , idBlocoCartao );
    }

    @Override
    public void add(IBlocoCartao entity, String idEstudante) throws EntityNotFoundException {

        IEstudante estudante = this._estudanteServico.getById(idEstudante);

        estudante.addBlocoCartao(entity);

        this._estudanteServico.update(estudante);
    }

    @Override
    public void update(IBlocoCartao entity, String idEstudante) throws EntityNotFoundException {

        IEstudante estudante     = this._estudanteServico.getById(idEstudante);
        IBlocoCartao blocoCartao = this.getItemCollectionById( estudante.getBlocoCartao() , entity.getId().toString() );

        blocoCartao.setNomeBloco( entity.getNomeBloco() );
        this._estudanteServico.update(estudante);
    }

    @Override
    public void delete(IBlocoCartao entity, String idEstudante) throws EntityNotFoundException {

        IEstudante estudante     = this._estudanteServico.getById(idEstudante);
        IBlocoCartao blocoCartao = this.getItemCollectionById( estudante.getBlocoCartao() , entity.getId().toString() );

        this.removeItemCollectionById( estudante.getBlocoCartao() , entity.getId().toString() );
        this._estudanteServico.update(estudante);
    }
}
