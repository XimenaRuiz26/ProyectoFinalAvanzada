package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.EventoDTO.*;

import java.util.List;

public interface EventoServicio {
    String crearEvento(CrearEventoDTO crearEventoDTO) throws Exception;

    String editarEvento(EditarEventoDTO editarEventoDTO) throws Exception;

    String eliminarEvento(String id) throws Exception;

    InfoEventoDTO obtenerInformacionEvento(String id) throws Exception;

    List<ItemEventoDTO> listarEventos();
    List<ItemEventoDTO> filtrarEventos(FiltroEventoDTO filtroEventoDTO);
}
