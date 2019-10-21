package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BlocoCartao extends EntidadeBasica implements IBlocoCartao {

    public  BlocoCartao() { super(); }

    String nomeBloco;
    List<ICartaoMemoria> listCartaoMemoria;

    @Override
    public ICartaoMemoria getCartaoMemoria(UUID id) {
        for (ICartaoMemoria cartaoMemoria: this.listCartaoMemoria ) {
            if( cartaoMemoria.getId().equals(id)){

                return cartaoMemoria;
            }
        }
        return null;
    }

    @Override
    public List<ICartaoMemoria> getCartaoMemoria() {
        return this.listCartaoMemoria;
    }

    @Override
    public void addCartaoMemoria(ICartaoMemoria cartaoMemoria) {
        if(this.listCartaoMemoria == null) {
            this.listCartaoMemoria = new ArrayList<ICartaoMemoria>();
        }
    }

    @Override
    public String getNomeBloco() {
        return this.nomeBloco;
    }

    @Override
    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }
}
