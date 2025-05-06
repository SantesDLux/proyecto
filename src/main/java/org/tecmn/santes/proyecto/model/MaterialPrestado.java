package org.tecmn.santes.proyecto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialPrestado {

    private ObjectId _id = new ObjectId();
    private String nombre_producto;
    private String nombre_solicitante;
    private String categoria;
    private String nombre_docente;
    private String nombre_materia;
    private int cantidad;
    // Formato: YYYY-MM-DD
    private String fecha_prestamo;
    // Formato: HH:mm
    private String hora_entrega;
    // Formato: YYYY-MM-DD
    private String fecha_devolucion;
}
