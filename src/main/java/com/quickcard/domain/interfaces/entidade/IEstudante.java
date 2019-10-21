package com.quickcard.domain.interfaces.entidade;

import java.util.List;
import java.util.UUID;

public interface IEstudante extends IEntidadeBasica {

    IBlocoCartao getBlocoCartao(UUID id);
    List<IBlocoCartao> getBlocoCartao();
    void addBlocoCartao(IBlocoCartao blocoCartao);

    public String getNome();
    public void setNome(String nome);
    public String getEmail();
    public void setEmail(String email);
    public String getSenha();
    public void setSenha(String senha);
}
