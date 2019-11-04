package com.quickcard.infra.contexto;

import com.mongodb.MongoClientURI;
import com.quickcard.domain.interfaces.infra.IDbContexto;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.FieldEnd;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import java.lang.reflect.Type;
import java.util.List;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class DbContexto implements IDbContexto {

    public DbContexto() {

    }

    private String _host = "127.0.0.1";
    private int _port = 27017;
    private String _dataBase = "admin";
    private String ConnectString = "mongodb://paulo:sCNSY9Sd52mt2VIVsFBg5hIflLe3JVyfmPPdxgxLNHQ0c5Om27zojqwJzhQxcnTl4ehxzkM8INkODCUlvd9bQg==@paulo.documents.azure.com:10255/?ssl=true&replicaSet=globaldb";

    private Datastore _datastore;
    private Datastore GetDatastore(){
        if(this._datastore == null){
            this._datastore = this.GetInstacia(this._dataBase);
        }

        return this._datastore;
    }

    private Datastore GetInstacia(String dataBase) {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.baeldung.morphia");
        MongoClient mongoClient = new MongoClient(new MongoClientURI(this.ConnectString));
        Datastore datastore = morphia.createDatastore(mongoClient, dataBase);
        datastore.ensureIndexes();
        return datastore;
    }

    @Override
    public <TEntity> void Add(TEntity entity ){

        Datastore datastore = this.GetDatastore();
        datastore.save(entity);
    }

    @Override
    public <TEntity> void Update(TEntity entity , Class<TEntity> classOfT){
        Datastore datastore = this.GetDatastore();

        this.Add(entity);
    }

    @Override
    public <TEntity> List<TEntity> GetAll(Class<TEntity> classOfT) {
        Datastore datastore = this.GetDatastore();

        Query<TEntity> _query = datastore.createQuery(classOfT);
        return _query.asList();
    }

    @Override
    public <TEntity> List<TEntity> where(Class<TEntity> classOfT , String _query) {

        Datastore datastore = this.GetDatastore();
        Query<TEntity> query = datastore.createQuery(classOfT);

        query.field(_query);
        return query.asList();
    }

    @Override
    public <TEntity> TEntity firsWhere(Class<TEntity> classOfT , String codicion , String _query) {

        Datastore datastore = this.GetDatastore();
        Query<TEntity> query = datastore.createQuery(classOfT).filter(codicion , _query );

        return query.first();
    }
}
