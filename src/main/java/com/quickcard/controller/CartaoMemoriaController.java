package com.quickcard.controller;

import com.quickcard.config.RoutesController;
import com.quickcard.domain.entidades.CartaoMemoria;
import com.quickcard.domain.entidades.Estudante;
import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.controller.IControllerRest;
import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.model.ICartaoMemoriaModel;
import com.quickcard.domain.interfaces.servico.ICartaoMemoriaServico;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import com.quickcard.model.CartaoMemoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class CartaoMemoriaController extends ControllerBasic {

    @Autowired
    private ICartaoMemoriaServico _cartaoMemoriaServico;

    @Autowired
    public CartaoMemoriaController(ICartaoMemoriaServico cartaoMemoriaServico) {

        this._cartaoMemoriaServico = cartaoMemoriaServico;
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH_ID_ESTUDANTE_ID_CARTAO , method = RequestMethod.GET)
    public ResponseEntity<?> getByIdCartao(@PathVariable("idEstudante") String idEstudante, @PathVariable("idCartao") String idCartao) throws Exception {
        try {

            ICartaoMemoria cartaoMemoria = this._cartaoMemoriaServico.getById(idEstudante , idCartao);

            return this.contentyBodyResponse( cartaoMemoria );

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH_ID_BLOCO , method = RequestMethod.POST )
    public ResponseEntity<?> created(@RequestBody CartaoMemoriaModel model, @PathVariable("idBloco") String idBloco) throws Exception {
        try {

            ICartaoMemoria entityCartaoMemoria = this.mapper.map(model , CartaoMemoria.class);

            this._cartaoMemoriaServico.add(entityCartaoMemoria , model.getIdEstudante() , idBloco );

            return ResponseEntity.created(URI.create("")).build();

        }catch (EntityNotFoundException err){

            return this.badRequestEntityNotFound(err);
        }
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH_ID_CARTAO , method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody CartaoMemoriaModel model, @PathVariable("idCartao") String idCartao) throws Exception {
        try {

            ICartaoMemoria entityCartaoMemoria = this.mapper.map(model , CartaoMemoria.class);

            entityCartaoMemoria.setId(UUID.fromString(idCartao));

            this._cartaoMemoriaServico.update(entityCartaoMemoria , model.getIdEstudante());

            return ResponseEntity.ok(entityCartaoMemoria);

        }catch (EntityNotFoundException err){

            return this.badRequestEntityNotFound(err);
        }
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH_ID_ESTUDANTE_ID_CARTAO , method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("idEstudante") String idEstudante, @PathVariable("idCartao") String idCartao) throws Exception {
        try {

            ICartaoMemoria cartaoMemoria = this._cartaoMemoriaServico.getById(idEstudante , idCartao);

            this._cartaoMemoriaServico.delete(cartaoMemoria , idEstudante);

            return ResponseEntity.noContent().build();

        }catch (EntityNotFoundException err) {

            return this.badRequestEntityNotFound(err);
        }
    }
}
