package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodigoValidacion {
    private String codigo;
    private LocalDateTime fechaCreacion;
}
