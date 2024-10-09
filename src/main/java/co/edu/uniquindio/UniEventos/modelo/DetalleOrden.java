package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class DetalleOrden {
    @EqualsAndHashCode.Include
    private String id;
    private String idEvento;
    private String nombreLocalidad;
    private int cantidad;
    private Float precio;
}
