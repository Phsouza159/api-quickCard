package com.quickcard.model;

import java.io.Serializable;

public class BlocoCartaoModel implements Serializable {

    public BlocoCartaoModel() {

    }

    public BlocoCartaoModel(String nomeBloco) {

        this.nomeBloco = nomeBloco;
    }

    public String nomeBloco;

    public String getNomeBloco() { return this.nomeBloco; }
    public void setNomeBloco(String nomeBloco) { this.nomeBloco = nomeBloco; }

}
