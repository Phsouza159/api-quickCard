package com.quickcard.domain.interfaces.entidade;

import java.util.List;
import java.util.UUID;

public interface IBlocoCartao extends IEntidadeBasica {

    ICartaoMemoria getCartaoMemoria(UUID id);
    List<ICartaoMemoria> getCartaoMemoria();
    void addCartaoMemoria(ICartaoMemoria cartaoMemoria);
    String getNomeBloco();
    void setNomeBloco(String nomeBloco);
}
