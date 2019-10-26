package com.quickcard.controller;


import com.quickcard.config.RoutesController;
import com.quickcard.domain.entidades.BlocoCartao;
import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.IBlocoCartaoServico;
import com.quickcard.model.BlocoCartaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.quickcard.domain.exception.*;

import java.io.Console;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class BlocoCartaoController extends ControllerBasic {

    @Autowired
    private  IBlocoCartaoServico _blocoCartaoServico;

    @Autowired
    public BlocoCartaoController(IBlocoCartaoServico blocoCartaoServico) {

        this._blocoCartaoServico = blocoCartaoServico;
    }

    @RequestMapping(value = RoutesController.BLOCO_CARTAO_MEMORIA_PATH_ID_ESTUDANTE, method = RequestMethod.GET)
    public ResponseEntity<?> getCollectionByIdEstudante(@PathVariable("idEstudante") String idEstudante) throws Exception {
        try {
            List<IBlocoCartao> blocoCartao = this._blocoCartaoServico.getAll(idEstudante);
            return this.contentyBodyResponse( blocoCartao );

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }

    @RequestMapping(value = RoutesController.BLOCO_CARTAO_MEMORIA_PATH_ID_BLOCO, method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable("idEstudante") String idEstudante , @PathVariable("idBloco") String idBloco) throws Exception {
        try {
            IBlocoCartao blocoCartao = this._blocoCartaoServico.getById(idEstudante , idBloco);
            return this.contentyBodyResponse( blocoCartao );

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }

    @RequestMapping(value = RoutesController.BLOCO_CARTAO_MEMORIA_PATH_ID_ESTUDANTE, method = RequestMethod.POST)
    public ResponseEntity<?> created(@RequestBody BlocoCartaoModel blocoCartaoModel , @PathVariable("idEstudante") String idEstudante) throws Exception {

        try{
            IBlocoCartao blocoCartao = this.mapper.map(blocoCartaoModel , BlocoCartao.class);

            this._blocoCartaoServico.add(blocoCartao , idEstudante );

            return ResponseEntity.created(URI.create("")).build();

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }

    @RequestMapping(value = RoutesController.BLOCO_CARTAO_MEMORIA_PATH_ID_BLOCO, method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody BlocoCartaoModel blocoCartaoModel , @PathVariable("idEstudante") String idEstudante , @PathVariable("idBloco") String idBloco) throws Exception {

        try{
            IBlocoCartao blocoCartao = this.mapper.map(blocoCartaoModel , BlocoCartao.class);
            blocoCartao.setId( UUID.fromString(idBloco) );

            this._blocoCartaoServico.update(blocoCartao , idEstudante );

            return ResponseEntity.noContent().build();

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }

    @RequestMapping(value = RoutesController.BLOCO_CARTAO_MEMORIA_PATH_ID_BLOCO, method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("idEstudante") String idEstudante , @PathVariable("idBloco") String idBloco) throws Exception {
        try {

            IBlocoCartao blocoCartao = this._blocoCartaoServico.getById(idEstudante , idBloco);
            this._blocoCartaoServico.delete(blocoCartao , idEstudante);

            return ResponseEntity.noContent().build();

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }


}
