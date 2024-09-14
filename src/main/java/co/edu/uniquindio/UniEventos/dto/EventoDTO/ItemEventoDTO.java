package co.edu.uniquindio.UniEventos.dto.EventoDTO;

import co.edu.uniquindio.UniEventos.modelo.TipoEvento;

public record ItemEventoDTO(
        String urlImagenPoster,
        String nombre,
        String fecha,
        String direccion,
        TipoEvento tipoEvento
) {
}
