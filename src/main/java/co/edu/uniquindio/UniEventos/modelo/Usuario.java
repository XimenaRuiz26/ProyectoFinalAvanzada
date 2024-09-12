package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Usuario {
    String nombre;
    String cedula;
    String telefono;
    String direccion;
}
