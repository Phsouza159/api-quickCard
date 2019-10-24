package com.quickcard.domain.interfaces.model;

public interface ICartaoMemoriaModel {

    String getIdEstudante();
    String getFrenteCartao();
    String getVersoCartao();

    void setFrenteCartao(String frente);
    void setVersoCartao(String verso);
    void setIdEstudante(String idEstudante);
}
