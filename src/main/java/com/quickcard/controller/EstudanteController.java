package com.quickcard.controller;

import com.quickcard.domain.interfaces.controller.IControllerRest;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import com.quickcard.domain.entidades.Estudante ;
import com.quickcard.model.EstudanteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class EstudanteController extends ControllerBasic  {

    @Autowired
    private IEstudanteServico _estudanteServico;

    private final static String path = "/estudante";

    @Autowired
    public EstudanteController(IEstudanteServico estudanteServico) {

        this._estudanteServico = estudanteServico;
    }

    @RequestMapping(value = EstudanteController.path, method = RequestMethod.GET)
    public ResponseEntity<List<IEstudante>> getAll() throws Exception {

        List<IEstudante> listEstudante = this._estudanteServico.getAll();

        return  ResponseEntity.ok(listEstudante);
    }

    @RequestMapping(value = EstudanteController.path + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<IEstudante> getByID(@PathVariable("id") String id) throws Exception {
        Objects.requireNonNull(id);

        IEstudante estudante = this._estudanteServico.getById(id);

        return  ResponseEntity.ok(estudante);
    }

    @RequestMapping(value = EstudanteController.path , method = RequestMethod.POST)
    public ResponseEntity<IEstudante> post(@RequestBody EstudanteModel estudanteModel) throws Exception {

        IEstudante responseEntity = this.mapper.map(estudanteModel , Estudante.class);

        this._estudanteServico.add(responseEntity);

        return  ResponseEntity.status(HttpStatus.CREATED).body(responseEntity);
    }

    @ResponseBody
    @RequestMapping(value = EstudanteController.path, method = RequestMethod.PUT)
    public ResponseEntity<IEstudante> put(@RequestBody EstudanteModel estudanteModel) throws Exception {

        throw  new NoSuchMethodException();
    }

}
