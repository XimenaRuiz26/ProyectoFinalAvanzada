package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CodigoValidacion {
    private String codigo;
    private LocalDateTime fechaCreacion;

    public CodigoValidacion(LocalDateTime fechaCreacion, String codigo) {
        this.fechaCreacion = fechaCreacion;
        this.codigo = codigo;
    }
}
