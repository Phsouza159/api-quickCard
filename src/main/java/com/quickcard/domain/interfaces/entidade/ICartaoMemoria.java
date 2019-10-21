package com.quickcard.domain.interfaces.entidade;

public interface ICartaoMemoria extends IEntidadeBasica {

    String GetFrenteCartao();
    String GetVersoCartao();
    void SetFrenteCartao(String frenteCartao);
    void SetVersoCartao(String versoCartao);
}
