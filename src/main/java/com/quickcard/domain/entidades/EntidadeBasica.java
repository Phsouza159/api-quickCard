package com.quickcard.domain.entidades;

import java.util.UUID;

import com.google.gson.Gson;
import com.quickcard.domain.interfaces.entidade.IEntidadeBasica;
import dev.morphia.annotations.Id;

public abstract class EntidadeBasica implements IEntidadeBasica {

    public UUID getId() {
        return UUID.fromString(Id);
    }

    public void setId(UUID Id) {
        this.Id = Id.toString();
    }

    @Id
    private String Id;

    public boolean isValid() {

        if(this.Id == null || this.Id == ""){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
