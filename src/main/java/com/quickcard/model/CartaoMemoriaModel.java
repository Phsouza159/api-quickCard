package com.quickcard.model;

import com.quickcard.domain.interfaces.model.ICartaoMemoriaModel;

import java.io.Serializable;

public class CartaoMemoriaModel  implements Serializable , ICartaoMemoriaModel {

    public CartaoMemoriaModel() {}


    String idEstudante;
    String frenteCartao;
    String versoCartao;

    String dataVisualizacao;
    String timeVisualizacao;

    int acertoFacil;
    int acertoMedio;

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
    public String getDataVisualizacao() {
        return this.getDataVisualizacao();
    }

    @Override
    public String getTimeVisualizacao() {
        return this.getTimeVisualizacao();
    }

    @Override
    public int getAcertoFacil() {
        return this.getAcertoFacil();
    }

    @Override
    public int getAcertoMedio() {
        return this.getAcertoMedio();
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

    @Override
    public void setAcertoFacil(int acertoFacil) {
        this.acertoFacil = acertoFacil;
    }

    @Override
    public void setAcertoMedio(int acertoMedio) {
        this.acertoMedio = acertoMedio;
    }
}
