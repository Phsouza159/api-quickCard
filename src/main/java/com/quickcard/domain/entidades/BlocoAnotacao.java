package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.IAnotacao;
import com.quickcard.domain.interfaces.entidade.IBlocoAnotacao;
import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BlocoAnotacao extends EntidadeBasica implements IBlocoAnotacao {

    public BlocoAnotacao() {
        super();
    }

    String nomeBlocoCartao;
    List<IAnotacao> listAnotacao;

    @Override
    public String getNomeBlocoCartao() {
        return this.nomeBlocoCartao;
    }

    @Override
    public void setNomeBlocoCartao(String nomeBlocoCartao) {
        this.nomeBlocoCartao = nomeBlocoCartao;
    }

    @Override
    public IAnotacao getAnotacao(UUID id) {
        for (IAnotacao anotacao : this.listAnotacao ) {
            if(anotacao.getId().equals(id)){
                return anotacao;
            }
        }
        return null;
    }

    @Override
    public List<IAnotacao> getAnotacao() {
        return this.listAnotacao;
    }

    @Override
    public void addAnotacao(IAnotacao anotacao) {
        if(this.listAnotacao == null) {
            this.listAnotacao = new ArrayList<IAnotacao>();
        }

        this.listAnotacao.add(anotacao);
    }
}
