package com.quickcard.controller;

import com.quickcard.config.RoutesController;
import com.quickcard.domain.interfaces.controller.IControllerRest;
import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;
import com.quickcard.domain.interfaces.servico.ICartaoMemoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
public class CartaoMemoriaController extends ControllerBasic implements IControllerRest {

    @Autowired
    private ICartaoMemoriaServico _cartaoMemoriaServico;

    @Autowired
    public CartaoMemoriaController(ICartaoMemoriaServico cartaoMemoriaServico) {

        this._cartaoMemoriaServico = cartaoMemoriaServico;
    }

    @Override
    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.GET)
    public ResponseEntity<List<ICartaoMemoria>> getAll(String idEstudante) throws Exception {

        List<ICartaoMemoria> response = this._cartaoMemoriaServico.getAll(idEstudante);

        return ResponseEntity.ok(response);
    }

    @Override
    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH + "/{id}", method = RequestMethod.GET)
    public <ITentity> ResponseEntity<ITentity> getById(String id, String idEstudante) throws Exception {
        return null;
    }

    @Override
    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.POST)
    public <ITentity, IModel> ResponseEntity<ITentity> created(IModel iModel) throws Exception {
        return null;
    }

    @Override
    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.PUT)
    public <ITentity, IModel> ResponseEntity<ITentity> update(IModel iModel) throws Exception {
        return null;
    }

    @Override
    @RequestMapping(value = RoutesController.CARTAO_MEMORIA_PATH , method = RequestMethod.DELETE)
    public <ITentity> ResponseEntity<ITentity> delete(String id, String idEstudante) throws Exception {
        return null;
    }
}
