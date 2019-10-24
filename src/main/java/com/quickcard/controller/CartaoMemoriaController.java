package com.quickcard.controller;

import com.quickcard.config.RoutesController;
import com.quickcard.domain.entidades.CartaoMemoria;
import com.quickcard.domain.entidades.Estudante;
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

import java.util.List;

@RestController
@CrossOrigin
public class CartaoMemoriaController extends ControllerBasic {

    @Autowired
    private ICartaoMemoriaServico _cartaoMemoriaServico;

    @Autowired
    private IEstudanteServico _estudanteServico;

    @Autowired
    public CartaoMemoriaController(ICartaoMemoriaServico cartaoMemoriaServico , IEstudanteServico estudanteServico) {

        this._cartaoMemoriaServico = cartaoMemoriaServico;
        this._estudanteServico     = estudanteServico;
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.GET)
    public ResponseEntity<List<ICartaoMemoria>> getAll(String idEstudante) throws Exception {

        List<ICartaoMemoria> response = this._cartaoMemoriaServico.getAll(idEstudante);

        if(response == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ICartaoMemoria> getById(String id, String idEstudante) throws Exception {

        ICartaoMemoria response = this._cartaoMemoriaServico.getById(idEstudante , id);

        if(response == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ICartaoMemoria> created(@RequestBody CartaoMemoriaModel model) throws Exception {

        ICartaoMemoria response = this.mapper.map(model , CartaoMemoria.class);


        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.PUT)
    public <ITentity, IModel> ResponseEntity<ITentity> update(IModel iModel) throws Exception {
        return null;
    }

    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.DELETE)
    public <ITentity> ResponseEntity<ITentity> delete(String id, String idEstudante) throws Exception {
        return null;
    }
}
