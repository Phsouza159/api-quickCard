package com.quickcard.domain.interfaces.entidade;

import com.quickcard.domain.entidades.Cronograma;

import java.util.ArrayList;
import java.util.List;

public interface IEstudante extends IEntidadeBasica {

    String nome = new String();
    String senha = new String();
    String email = new String();
    List<Cronograma> cronogramas = null;

    public List<Cronograma> getCronogramas();

    public void setCronogramas(List<Cronograma> cronogramas);

    public void addCronograma(Cronograma cronogramas);

    public String getNome();

    public void setNome(String nome);

    public String getEmail();

    public void setEmail(String email);

    public String getSenha();

    public void setSenha(String senha);
}
