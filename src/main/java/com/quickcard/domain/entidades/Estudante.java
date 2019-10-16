package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.IEstudante;

import java.util.ArrayList;
import java.util.List;

public class Estudante extends EntidadeBasica implements IEstudante {

    public Estudante() {

    }

    String nome;
    String senha;
    String email;
    List<Cronograma> cronogramas;

    public List<Cronograma> getCronogramas() {
        return cronogramas;
    }

    public void setCronogramas(List<Cronograma> cronogramas) {
        this.cronogramas = cronogramas;
    }

    public void addCronograma(Cronograma cronogramas){

        if(this.cronogramas == null)
            this.cronogramas = new ArrayList<Cronograma>();

        this.cronogramas.add(cronogramas);
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
