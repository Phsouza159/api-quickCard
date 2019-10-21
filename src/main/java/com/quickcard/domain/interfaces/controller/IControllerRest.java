package com.quickcard.domain.interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IControllerRest {



    <ITentity> ResponseEntity<List<ITentity>> getAll(String idEstudante) throws Exception;

    <ITentity> ResponseEntity<ITentity> getById(@PathVariable("id") String id , String idEstudante) throws Exception;

    <ITentity , IModel> ResponseEntity<ITentity> created(@RequestBody IModel model) throws Exception;

    <ITentity , IModel> ResponseEntity<ITentity> update(@RequestBody IModel model) throws Exception;

    <ITentity> ResponseEntity<ITentity> delete(@PathVariable("id") String id, String idEstudante) throws Exception;
}
