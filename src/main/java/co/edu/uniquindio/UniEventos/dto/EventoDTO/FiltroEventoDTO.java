package co.edu.uniquindio.UniEventos.dto.EventoDTO;

import co.edu.uniquindio.UniEventos.modelo.TipoEvento;

public record FiltroEventoDTO(
        String nombre,
        TipoEvento tipoEvento,
        String ciudad
) {
}
