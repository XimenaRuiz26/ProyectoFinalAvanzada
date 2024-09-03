package co.edu.uniquindio.UniEventos.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Document("eventos")
public class Evento {
    String id;
    String nombre;
    String descripcion;
    String direccion;
    String ciudad;
    LocalDateTime fecha;
    TipoEvento tipo;
    EstadoEvento estado;
    String imagenPortada;
    String imagenLocalidad;
    List<Localidad> localidades;
    List<Alojamiento> alojamientosCercanos;

}
