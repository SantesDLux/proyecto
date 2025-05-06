package org.tecmn.santes.proyecto.controller;

import org.bson.types.ObjectId;
import org.tecmn.santes.proyecto.model.MaterialPrestado;
import org.tecmn.santes.proyecto.repository.MaterialPrestadoRepository;

import java.util.List;

public class MaterialPrestadoController {
    private final MaterialPrestadoRepository repository;

    public MaterialPrestadoController() {
        this.repository = new MaterialPrestadoRepository();
    }

    public void agregarMaterial(MaterialPrestado material) {
        repository.guardar(material);
    }

    public List<MaterialPrestado> obtenerMateriales() {
        return repository.obtenerTodos();
    }

    public MaterialPrestado obtenerMaterialPorId(ObjectId id) {
        return repository.obtenerPorId(id);
    }

    public void actualizarMaterial(MaterialPrestado material) {
        repository.actualizar(material);
    }

    public void eliminarMaterial(ObjectId id) {
        repository.eliminar(id);
    }
}