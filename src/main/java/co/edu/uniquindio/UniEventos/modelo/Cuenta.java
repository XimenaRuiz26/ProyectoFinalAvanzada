package co.edu.uniquindio.UniEventos.modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Cuenta {
    String id;
    Usuario user;
    String password;
    String email;
    Rol rol;
    EstadoCuenta estado;
    LocalDateTime fechaRegistro;
    CodigoValidacion codigoValidacionRegistro;
    CodigoValidacion codigoValidacionPassword;
    List<String> busquedasEventos;

}
