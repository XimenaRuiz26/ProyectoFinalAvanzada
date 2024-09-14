package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.CuponDTO.CrearCuponDTO;
import co.edu.uniquindio.UniEventos.dto.CuponDTO.EditarCuponDTO;
import co.edu.uniquindio.UniEventos.dto.CuponDTO.InfoCuponDTO;

public interface CuponServicio {
    String crearCupones(CrearCuponDTO cuponDTO);
    String actualizarCupon(EditarCuponDTO cuponDTO);
    void borrarCupon(String idCupon);
    boolean validarCupon(String idCupon, String userId);
    String redimirCupon(String idCupon, String idCliente);
    InfoCuponDTO listarCupones(String idCupon, String idCliente);
}
