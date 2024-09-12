package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.modelo.*;
import co.edu.uniquindio.UniEventos.servicios.interfaces.CuentaServicio;

import java.time.LocalDateTime;

public class CuentaServicioImpl implements CuentaServicio {
    private final CuentaRepo cuentaRepo;

    String codigoAletorio= generarCodigo();

    private String generarCodigo() {
    }

    public String crearCuenta(CrearCuentaDTO cuenta) throws Exception{
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setEmail(cuenta.email());
        nuevaCuenta.setPassword(cuenta.password());
        nuevaCuenta.setRol(Rol.CLIENTE);
        nuevaCuenta.setFechaRegistro(LocalDateTime.now());
        nuevaCuenta.setUsuario(new Usuario(
                cuenta.cedula(),
                cuenta.nombre(),
                cuenta.telefono(),
                cuenta.direccion()
        ));
        nuevaCuenta.setEstado(EstadoCuenta.INACTIVA);
        nuevaCuenta.setCodigoValidacionRegistro(
                new CodigoValidacion(codigoAletorio,  //METODO QUE GENERE EL CODIGO ALEATORIAMENTE  //generarCodigo()
                        LocalDateTime.now()
                )
        );

        Cuenta cuentaCreada = cuentaRepo.save(nuevaCuenta);

        //ENVIAR UN EMAIL AL USUARIO CON LA VALIDACIÓN

        return"SU CUENTA SE HA CREADO CORRECTAMENTE";
    }
}
