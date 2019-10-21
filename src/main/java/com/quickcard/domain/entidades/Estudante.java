package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;
import com.quickcard.domain.interfaces.entidade.IEstudante;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Estudante extends EntidadeBasica implements IEstudante {

    public Estudante() { super(); }

    String nome;
    String senha;
    String email;
    List<IBlocoCartao> listBlocoCartao;


    @Override
    public IBlocoCartao getBlocoCartao(UUID id) {
        for ( IBlocoCartao blocoCartao: this.listBlocoCartao) {
            if(blocoCartao.getId().equals(id)){
                return blocoCartao;
            }
        }
        return null;
    }

    @Override
    public List<IBlocoCartao> getBlocoCartao() {
        return this.listBlocoCartao;
    }

    @Override
    public void addBlocoCartao(IBlocoCartao blocoCartao) {
        if(this.listBlocoCartao == null){

            this.listBlocoCartao = new ArrayList<IBlocoCartao>();
        }
        this.listBlocoCartao.add(blocoCartao);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
