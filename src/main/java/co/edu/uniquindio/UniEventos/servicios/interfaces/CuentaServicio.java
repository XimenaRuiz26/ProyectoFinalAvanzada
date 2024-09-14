package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.CuentaDTO.*;

public interface CuentaServicio {
    String crearCuenta(CrearCuentaDTO cuenta) throws Exception;

    boolean activarCuenta(ActivarCuentaDTO activarCuentaDTO) throws Exception;

    String generarCodigo();

    String editarCuenta(EditarCuentaDTO cuenta) throws Exception;

    String eliminarCuenta(String id) throws Exception;

    InfoCuentaDTO obtenerInformacionCuenta(String id) throws Exception;

    String enviarCodigoRecuperacionPassword(String correo) throws Exception;

    String cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception;

    String iniciarSesion(LoginDTO loginDTO) throws Exception;
}
