package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
    @EqualsAndHashCode.Include
    private String id;
    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;

    public Usuario(String nombre, String direccion, String telefono) {
    }
}
