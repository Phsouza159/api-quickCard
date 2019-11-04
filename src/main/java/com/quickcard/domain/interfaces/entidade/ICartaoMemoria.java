package com.quickcard.domain.interfaces.entidade;

public interface ICartaoMemoria extends IEntidadeBasica {

    String getFrenteCartao();
    String getVersoCartao();

    String getDataVisualizacao();
    String getTimeVisualizacao();

    int getAcertoFacil();
    int getAcertoMedio();
    int getAcertoDificil();

    void setFrenteCartao(String frenteCartao);
    void setVersoCartao(String versoCartao);

    void setDataVisualizacao(String dataVisualizacao);
    void setTimeVisualizacao(String timeVisualizacao);

    void setAcertoFacil(int acertoFacil);
    void setAcertoMedio(int acertoMedio);
}
