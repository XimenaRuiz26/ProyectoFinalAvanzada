package co.edu.uniquindio.UniEventos.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("alojamientos")
public class Alojamiento {
    String id;
    String nombre;
    String ciudad;
    Float precioNoche;
    Float calificacion;
    Float distanciaEvento;
    TipoAlojamiento tipo;
}
