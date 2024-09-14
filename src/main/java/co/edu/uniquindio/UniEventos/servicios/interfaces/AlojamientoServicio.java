package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.AlojamientoDTO.CrearAlojamientoDTO;
import co.edu.uniquindio.UniEventos.dto.AlojamientoDTO.ItemAlojamientoDTO;
import co.edu.uniquindio.UniEventos.dto.CuentaDTO.CrearCuentaDTO;
import co.edu.uniquindio.UniEventos.dto.EventoDTO.FiltroEventoDTO;
import co.edu.uniquindio.UniEventos.dto.EventoDTO.ItemEventoDTO;

import java.util.List;

public interface AlojamientoServicio {
    String crearAlojamiento(CrearAlojamientoDTO alojamiento) throws Exception;

    List<ItemAlojamientoDTO> listarAlojamientos();

}
