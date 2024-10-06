package co.edu.uniquindio.UniEventos.dto.CuponDTO;

import co.edu.uniquindio.UniEventos.modelo.EstadoCupon;
import co.edu.uniquindio.UniEventos.modelo.TipoCupon;

import java.time.LocalDateTime;

public record InfoCuponDTO(
        String nombre,
        String codigo,
        float descuento,
        LocalDateTime fechaVencimiento,
        TipoCupon tipo,
        EstadoCupon estado
) {
}
