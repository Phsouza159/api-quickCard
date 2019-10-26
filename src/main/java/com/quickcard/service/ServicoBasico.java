package com.quickcard.service;

import com.quickcard.domain.exception.EntityNotFoundException;
import com.quickcard.domain.interfaces.entidade.IEntidadeBasica;
import com.quickcard.domain.interfaces.servico.IServicoBasico;
import org.dozer.DozerBeanMapper;

import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ServicoBasico implements IServicoBasico {

    protected DozerBeanMapper mapper;

    public ServicoBasico() {

        this.mapper = new DozerBeanMapper();
    }

    public <TEntity extends  IEntidadeBasica> TEntity getItemCollectionById(List<TEntity> entityList , String id) throws EntityNotFoundException {

        if(entityList != null) {
            for(TEntity entity : entityList){
                String idString = entity.getId().toString();
                if( idString.equals(id)) {
                    return entity;
                }
            }
        }

        throw new EntityNotFoundException();
    }

    public <TEntity extends  IEntidadeBasica> List<TEntity> removeItemCollectionById(List<TEntity> entityList , String id) throws EntityNotFoundException {

        TEntity entity = this.getItemCollectionById(entityList , id);

        entityList.remove(entity);

        return  entityList;
    }


    public String hashSenha(String senhaPura) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senhaPura.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhaCodificada = hexString.toString();
            return senhaCodificada;

        } catch (Exception err) {

            Logger.getLogger(JwtUserDetailsService.class.getName()).log(Level.SEVERE, null, err);
            return "";
        }
    }
}
