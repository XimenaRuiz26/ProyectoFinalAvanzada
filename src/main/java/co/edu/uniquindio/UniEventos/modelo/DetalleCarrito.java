package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DetalleCarrito {
    String id;
    ObjectId idEvento;
    String nombreLocalidad;
}
