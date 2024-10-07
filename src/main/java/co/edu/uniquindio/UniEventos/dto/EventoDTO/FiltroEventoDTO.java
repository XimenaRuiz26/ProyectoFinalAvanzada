package co.edu.uniquindio.UniEventos.dto.EventoDTO;

import co.edu.uniquindio.UniEventos.modelo.Localidad;
import co.edu.uniquindio.UniEventos.modelo.TipoEvento;

import java.time.LocalDateTime;
import java.util.List;

public record FiltroEventoDTO(
        String imagenPortada,
        String nombre,
        String direccion,
        String ciudad,
        LocalDateTime fecha,
        TipoEvento tipoEvento,
        List<Localidad> localidades
) {
}
