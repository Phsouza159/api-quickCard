package com.quickcard.domain.interfaces.model;

public interface ICartaoMemoriaModel {

    String getIdEstudante();
    String getFrenteCartao();
    String getVersoCartao();

    String getDataVisualizacao();
    String getTimeVisualizacao();

    int getAcertoFacil();
    int getAcertoMedio();

    void setFrenteCartao(String frente);
    void setVersoCartao(String verso);
    void setIdEstudante(String idEstudante);

    void setAcertoFacil(int acertoFacil);
    void setAcertoMedio(int acertoMedio);

}
