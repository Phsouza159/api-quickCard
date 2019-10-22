package com.quickcard.model;

import com.quickcard.domain.interfaces.model.ICartaoMemoriaModel;

import java.io.Serializable;

public class CartaoMemoriaModel  implements Serializable , ICartaoMemoriaModel {

    public CartaoMemoriaModel() {}

    public CartaoMemoriaModel(String frenteCartao, String versoCartao) {
        this.frenteCartao = frenteCartao;
        this.versoCartao = versoCartao;
    }

    String frenteCartao;
    String versoCartao;

    @Override
    public String getFrenteCartao() {
        return this.frenteCartao;
    }

    @Override
    public String getVersoCartao() {
        return this.versoCartao;
    }

    @Override
    public void setFrenteCartao(String frente) {
        this.frenteCartao = frente;
    }

    @Override
    public void setVersoCartao(String verso) {
        this.versoCartao = verso;
    }
}
