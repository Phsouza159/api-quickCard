package com.quickcard.controller;

import com.google.gson.Gson;
import com.quickcard.domain.entidades.EntidadeBasica;
import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.IEntidadeBasica;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.reflect.Type;
import java.util.List;


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

    protected <TEntityResponse extends IEntidadeBasica> ResponseEntity<TEntityResponse> badRequestEntityNotFound(EntityNotFoundException exception) {

        System.out.println(exception.getMessage()  + " :: " + exception.getStackTrace() );
        ResponseEntity response = ResponseEntity.badRequest().body(exception.getMessage());
        return response;
    }

    protected <TEntityResponse extends IEntidadeBasica> ResponseEntity<List<TEntityResponse>> contentyBodyResponse(List<TEntityResponse> listEntityResonse) {

        if(listEntityResonse == null || listEntityResonse.size() < 1) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listEntityResonse);
    }

    protected <TEntityResponse extends IEntidadeBasica> ResponseEntity<TEntityResponse> contentyBodyResponse(TEntityResponse entityResonse) {

        if(entityResonse == null ) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(entityResonse);
    }
}
