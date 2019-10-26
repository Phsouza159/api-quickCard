package com.quickcard.service;

import com.quickcard.domain.entidades.Estudante;
import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IEstudante;
import com.quickcard.domain.interfaces.infra.IDbContexto;
import com.quickcard.domain.interfaces.servico.IEstudanteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstudanteServico extends ServicoBasico implements IEstudanteServico {

    private IDbContexto DbContexto;

    @Autowired
    public EstudanteServico(IDbContexto dbContexto) {

        this.DbContexto = dbContexto;
    }

    @Override
    public IEstudante getByEmail(String email){

       return this.DbContexto.firsWhere(  Estudante.class ,"email" , email);
    }

    @Override
    public List<IEstudante> getAll() {

        List<Estudante> list = this.DbContexto.GetAll( Estudante.class);
        return (List<IEstudante>)(Object) list;
    }

    @Override
    public IEstudante getById(String id) throws EntityNotFoundException {
        IEstudante estudante = this.DbContexto.firsWhere(Estudante.class , "_id" , id);

        if(estudante == null) {
            throw new EntityNotFoundException("A entidade estudante não foi localizada na base com o id " + id);
        }

        return estudante;
    }

    @Override
    public void add(IEstudante estudanteEntity) {

        estudanteEntity.setId( UUID.randomUUID());
        estudanteEntity.setSenha(this.hashSenha(estudanteEntity.getSenha()));

        this.DbContexto.Add(estudanteEntity);
    }

    @Override
    public void update(IEstudante estudanteEntity) {

        this.DbContexto.Add(estudanteEntity);
    }

}
