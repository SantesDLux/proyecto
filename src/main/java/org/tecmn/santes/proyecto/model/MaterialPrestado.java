package org.tecmn.santes.proyecto.model;

import org.bson.types.ObjectId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonId;

public class MaterialPrestado {
    @BsonId
    private ObjectId _id = new ObjectId();
    
    @BsonProperty("nombre_producto")
    private String nombre_producto;
    
    @BsonProperty("nombre_solicitante")
    private String nombre_solicitante;
    
    @BsonProperty("categoria")
    private String categoria;
    
    @BsonProperty("nombre_docente")
    private String nombre_docente;
    
    @BsonProperty("nombre_materia")
    private String nombre_materia;
    
    @BsonProperty("cantidad")
    private int cantidad;
   
    @BsonProperty("fecha_prestamo")
    private String fecha_prestamo;
    
    @BsonProperty("hora_entrega")
    private String hora_entrega;
    
    @BsonProperty("fecha_devolucion")
    private String fecha_devolucion;
    
    public MaterialPrestado() {
    }
    
    public MaterialPrestado(String nombre_producto, String nombre_solicitante, String categoria, String nombre_docente, String nombre_materia, int cantidad, String fecha_prestamo, String hora_entrega, String fecha_devolucion) {
        this.nombre_producto = nombre_producto;
        this.nombre_solicitante = nombre_solicitante;
        this.categoria = categoria;
        this.nombre_docente = nombre_docente;
        this.nombre_materia = nombre_materia;
        this.cantidad = cantidad;
        this.fecha_prestamo = fecha_prestamo;
        this.hora_entrega = hora_entrega;
        this.fecha_devolucion = fecha_devolucion;
    }
     
    // Corregir el getter para el _id
    public ObjectId get_id() {
        return _id;
    }
    
    // Opcional: renombrado para consistencia
    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    
    // También puedes mantener los anteriores para compatibilidad
    public ObjectId getId() {
        return _id;
    }
    
    public void setId(ObjectId _id) {
        this._id = _id;
    }
    
    public String getNombre_producto() {
        return nombre_producto;
    }
    
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    public String getNombre_solicitante() {
        return nombre_solicitante;
    }
    
    public void setNombre_solicitante(String nombre_solicitante) {
        this.nombre_solicitante = nombre_solicitante;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getNombre_docente() {
        return nombre_docente;
    }
    
    public void setNombre_docente(String nombre_docente) {
        this.nombre_docente = nombre_docente;
    }
    
    public String getNombre_materia() {
        return nombre_materia;
    }
    
    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getFecha_prestamo() {
        return fecha_prestamo;
    }
    
    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }
    
    public String getHora_entrega() {
        return hora_entrega;
    }
    
    public void setHora_entrega(String hora_entrega) {
        this.hora_entrega = hora_entrega;
    }
    
    public String getFecha_devolucion() {
        return fecha_devolucion;
    }
    
    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
}