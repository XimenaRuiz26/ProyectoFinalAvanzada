package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.EventoDTO.*;
import co.edu.uniquindio.UniEventos.excepciones.EventoException;
import co.edu.uniquindio.UniEventos.modelo.Evento;
import co.edu.uniquindio.UniEventos.modelo.TipoEvento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EventoServicio {
    String crearEvento(CrearEventoDTO crearEventoDTO) throws Exception;

    String editarEvento(EditarEventoDTO editarEventoDTO) throws Exception;

    String eliminarEvento(String id) throws Exception;

    InfoEventoDTO obtenerInformacionEvento(String id) throws Exception;

    List<ItemEventoDTO> listarEventos();
    List<ItemEventoDTO> filtrarEventos(FiltroEventoDTO filtroEventoDTO);

    List<FiltroEventoDTO> filtrarPorTipo(TipoEvento tipoEvento);

    List<FiltroEventoDTO> filtrarPorFecha(LocalDate fecha);

    List<FiltroEventoDTO> filtrarPorCiudad(String ciudad);

    List<FiltroEventoDTO> filtrarPorAlojamientosCercanos(String ciudad, String direccion);

    List<FiltroEventoDTO> filtrarPorRangoDeFechas(LocalDateTime desde, LocalDateTime hasta);

    Evento obtenerEvento(String id) throws EventoException;

    List<Evento> getAll();

    void actualizarCapacidadLocalidad(Evento evento, String nombreLocalidad, int entradasVendidas) throws Exception;
}
