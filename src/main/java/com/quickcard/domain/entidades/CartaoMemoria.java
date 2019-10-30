package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;

public class CartaoMemoria extends EntidadeBasica implements ICartaoMemoria {

    public CartaoMemoria() { super(); }

    private String frenteCartao;
    private String versoCartao;

    @Override
    public String getFrenteCartao() {
        return this.frenteCartao;
    }

    @Override
    public String getVersoCartao()  {
        return this.versoCartao;
    }

    @Override
    public void setFrenteCartao(String frenteCartao) {
        this.frenteCartao = frenteCartao;
    }

    @Override
    public void setVersoCartao(String versoCartao) {
        this.versoCartao = versoCartao;
    }
}
