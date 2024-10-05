package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.CuentaDTO.*;
import co.edu.uniquindio.UniEventos.dto.TokenDTO;

import java.util.List;

public interface CuentaServicio {
    String crearCuenta(CrearCuentaDTO cuenta) throws Exception;

    boolean activarCuenta(ActivarCuentaDTO activarCuentaDTO) throws Exception;

    String editarCuenta(EditarCuentaDTO cuenta) throws Exception;

    String eliminarCuenta(String id) throws Exception;

    InfoCuentaDTO obtenerInformacionCuenta(String id) throws Exception;

    String enviarCodigoRecuperacionPassword(String correo) throws Exception;

    String cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception;

    TokenDTO iniciarSesion(LoginDTO loginDTO) throws Exception;

    List<InfoCuentaDTO> listarCuentas();

}
