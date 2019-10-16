package com.quickcard.controller;

import com.google.gson.Gson;
import com.quickcard.domain.entidades.EntidadeBasica;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.reflect.Type;


@CrossOrigin
public abstract class ControllerBasic {

    private Gson _gson;
    protected Mapper mapper;

    public ControllerBasic() {

        this._gson = new Gson();
        this.mapper = new DozerBeanMapper();
    }

    protected String serializar(Object object) {
        return this._gson.toJson(object);
    }

    protected <TEntity extends EntidadeBasica> TEntity mapping(String bson , Type classOfT) {

        return this._gson.fromJson(bson, classOfT);
    }
}
