package com.quickcard.domain.interfaces.entidade;

public interface ICartaoMemoria extends IEntidadeBasica {

    String getFrenteCartao();
    String getVersoCartao();
    void setFrenteCartao(String frenteCartao);
    void setVersoCartao(String versoCartao);
}
