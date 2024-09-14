package co.edu.uniquindio.UniEventos.dto.AlojamientoDTO;

import co.edu.uniquindio.UniEventos.modelo.TipoAlojamiento;

public record ItemAlojamientoDTO(
        String nombre,
        String calificacion,
        float precioNoche,
        float distanciaEvento,
        TipoAlojamiento tipo
) {
}
