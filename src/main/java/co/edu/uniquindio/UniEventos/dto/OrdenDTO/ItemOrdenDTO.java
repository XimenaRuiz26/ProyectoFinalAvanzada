package co.edu.uniquindio.UniEventos.dto.OrdenDTO;

import java.time.LocalDateTime;

public record ItemOrdenDTO(
        String id,
        LocalDateTime fecha,
        float total
) {
}
