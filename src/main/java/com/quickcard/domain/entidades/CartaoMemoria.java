package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;

public class CartaoMemoria extends EntidadeBasica implements ICartaoMemoria {

    public CartaoMemoria() { super(); }

    private String frenteCartao;
    private String versoCartao;

    @Override
    public String GetFrenteCartao() {
        return this.frenteCartao;
    }

    @Override
    public String GetVersoCartao()  {
        return this.versoCartao;
    }

    @Override
    public void SetFrenteCartao(String frenteCartao) {
        this.frenteCartao = frenteCartao;
    }

    @Override
    public void SetVersoCartao(String versoCartao) {
        this.versoCartao = versoCartao;
    }
}
