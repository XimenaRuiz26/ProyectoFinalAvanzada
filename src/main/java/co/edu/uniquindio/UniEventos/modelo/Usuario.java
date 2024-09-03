package co.edu.uniquindio.UniEventos.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuarios")
public class Usuario {
    String id;
    String nombre;
    String cedula;
    String telefono;
    String direccion;

}
