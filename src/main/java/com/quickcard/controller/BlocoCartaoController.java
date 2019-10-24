package com.quickcard.controller;


import com.quickcard.config.RoutesController;
import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IBlocoCartao;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.IBlocoCartaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.quickcard.domain.exception.*;

import java.io.Console;
import java.util.List;

@RestController
@CrossOrigin
public class BlocoCartaoController extends ControllerBasic {

    @Autowired
    private  IBlocoCartaoServico _blocoCartaoServico;

    @Autowired
    public BlocoCartaoController(IBlocoCartaoServico blocoCartaoServico) {

        this._blocoCartaoServico = blocoCartaoServico;
    }

    @RequestMapping(value = RoutesController.BLOCO_CARTAO_MEMORIA_PATH, method = RequestMethod.GET)
    public ResponseEntity<?> getAll() throws Exception {

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = RoutesController.BLOCO_CARTAO_MEMORIA_PATH_ID, method = RequestMethod.GET)
    public ResponseEntity<?> getAllById(String idEstudante) throws Exception {
        try {

            List<IBlocoCartao> blocoCartao = this._blocoCartaoServico.getAll(idEstudante);
            return this.contentyBodyResponse( blocoCartao );

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }

}
