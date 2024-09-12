package co.edu.uniquindio.UniEventos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrden {
    String id;
    ObjectId idEvento;
    String nombreLocalidad;
    int cantidad;
    Float precio;
}
