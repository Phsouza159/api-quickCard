package com.quickcard.domain.interfaces.entidade;

import java.util.UUID;

public interface IEntidadeBasica {
    UUID getId();
    void setId(UUID Id);
    boolean isValid();
}
