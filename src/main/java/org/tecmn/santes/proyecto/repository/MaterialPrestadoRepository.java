package org.tecmn.santes.proyecto.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.types.ObjectId;
import org.tecmn.santes.proyecto.model.MaterialPrestado;
import org.tecmn.santes.proyecto.bd.BDConexion;

import java.util.ArrayList;
import java.util.List;

public class MaterialPrestadoRepository {
    private final MongoCollection<MaterialPrestado> collection;

    public MaterialPrestadoRepository() {
        this.collection = BDConexion.getCollection(); 
    }

    public void guardar(MaterialPrestado material) {
        collection.insertOne(material);
    }

    public List<MaterialPrestado> obtenerTodos() {
        return collection.find().into(new ArrayList<>());
    }

    public MaterialPrestado obtenerPorId(ObjectId id) {
        return collection.find(Filters.eq("_id", id)).first();
    }

    public void actualizar(MaterialPrestado material) {
        ReplaceOptions options = new ReplaceOptions().upsert(false);
        collection.replaceOne(Filters.eq("_id", material.get_id()), material, options);
    }

    public void eliminar(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
    }
}