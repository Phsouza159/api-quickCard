package com.quickcard.domain.interfaces.infra;

import java.util.List;

public interface IDbContexto {

    <TEntity> void Add(TEntity entity );
    <TEntity> void Update(TEntity entity , Class<TEntity> classOfT);
    <TEntity> List<TEntity> GetAll(Class<TEntity> classOfT);
    <TEntity> List<TEntity> where(Class<TEntity> classOfT , String _query);
    <TEntity> TEntity firsWhere(Class<TEntity> classOfT , String codicion , String _query);
}
