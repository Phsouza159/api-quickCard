package com.quickcard.domain.interfaces.entidade;

import java.util.List;
import java.util.UUID;

public interface IBlocoAnotacao extends IEntidadeBasica {

    String getNomeBlocoCartao();
    void setNomeBlocoCartao(String nomeBlocoCartao);
    IAnotacao getAnotacao(UUID id);
    List<IAnotacao> getAnotacao();
    void addAnotacao(IAnotacao anotacao);

}
