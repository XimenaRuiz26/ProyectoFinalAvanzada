package co.edu.uniquindio.UniEventos.dto.OrdenDTO;

import co.edu.uniquindio.UniEventos.modelo.DetalleOrden;
import co.edu.uniquindio.UniEventos.modelo.Pago;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public record InfoOrdenDTO(
        ObjectId idUser,
        LocalDateTime fecha,
        String codigoPasarela,
        List<DetalleOrden> items,
        Pago pago,
        String id,
        float total,
        ObjectId idCupon) {
}
