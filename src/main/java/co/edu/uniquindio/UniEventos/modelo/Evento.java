package co.edu.uniquindio.UniEventos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("eventos")
public class Evento {
    @Id
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
