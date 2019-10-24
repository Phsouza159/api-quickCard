package com.quickcard.model;

import com.quickcard.domain.interfaces.model.ICartaoMemoriaModel;

import java.io.Serializable;

public class CartaoMemoriaModel  implements Serializable , ICartaoMemoriaModel {

    public CartaoMemoriaModel() {}

    public CartaoMemoriaModel(String idEstudante, String frenteCartao, String versoCartao) {
        this.idEstudante  = idEstudante;
        this.frenteCartao = frenteCartao;
        this.versoCartao  = versoCartao;
    }

    String idEstudante;
    String frenteCartao;
    String versoCartao;

    @Override
    public String getIdEstudante() { return this.idEstudante;  }

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

    @Override
    public void setIdEstudante(String idEstudante) { this.idEstudante = idEstudante; }
}
