package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.IAnotacao;

public class Anotacao extends EntidadeBasica implements IAnotacao {

    public  Anotacao() {
        super();
    }

    String nome;
    String conteudo;

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void SetNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getConteudo() {
        return this.conteudo;
    }

    @Override
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
