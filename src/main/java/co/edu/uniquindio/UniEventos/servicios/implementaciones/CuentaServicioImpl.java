package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.CuentaDTO.*;
import co.edu.uniquindio.UniEventos.dto.TokenDTO;
import co.edu.uniquindio.UniEventos.modelo.*;
import co.edu.uniquindio.UniEventos.repositorios.CuentaRepo;
import co.edu.uniquindio.UniEventos.servicios.interfaces.CuentaServicio;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CuentaServicioImpl implements CuentaServicio {
    CuentaRepo cuentaRepo;
    private String ejemplo;

    @Override
    public String crearCuenta(CrearCuentaDTO cuenta) throws Exception {
        if (existeEmail(cuenta.email())) {
            throw new Exception("El correo:" + cuenta.email() + " ya existe");
        }

        if (existeCedula(cuenta.cedula())) {
            throw new Exception("La cedula:" + cuenta.cedula() + " ya existe");
        }

        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setId(cuenta.cedula());
        nuevaCuenta.setRol(Rol.CLIENTE);
        nuevaCuenta.setEstado(EstadoCuenta.INACTIVA);
        nuevaCuenta.setEmail(cuenta.email());
        nuevaCuenta.setPassword(cuenta.password());
        nuevaCuenta.setFechaRegistro(LocalDateTime.now());
//        nuevaCuenta.setCodigoValidacionRegistro(new CodigoValidacion(generarCodigo(), LocalDateTime.now()));
//        nuevaCuenta.setUsuario(new Usuario(
//                cuenta.nombre(),
//                cuenta.direccion(),
//                cuenta.telefonos()
//        ));
        Cuenta cuentaCreada = cuentaRepo.save(nuevaCuenta);
        return cuentaCreada.getId();
    }

    @Override
    public boolean activarCuenta(ActivarCuentaDTO activarCuentaDTO) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.buscarEmail(activarCuentaDTO.email());

        if (cuentaOptional.isEmpty()) {
            throw new Exception("Cuenta no existe");
        }
        Cuenta cuenta = cuentaOptional.get();
//        if (!activarCuentaDTO.codigoVerificacion().equals(cuenta.getCodigoValidacionRegistro().getCodigo())) {
//            throw new Exception("Código de verificación incorrecto");
//        }

        LocalDateTime fechaCreacion = cuenta.getCodigoValidacionRegistro().getFechaCreacion();
        LocalDateTime fechaActual = LocalDateTime.now();
        Duration duracionValidez = Duration.ofMinutes(15);

        if (Duration.between(fechaCreacion, fechaActual).compareTo(duracionValidez) > 0) {
            throw new Exception("El código de verificación ha expirado");
        }

        cuenta.setEstado(EstadoCuenta.ACTIVA);
        cuenta.setCodigoValidacionRegistro(null);
        cuentaRepo.save(cuenta);

        return true;
    }



    @Override
    public String editarCuenta(EditarCuentaDTO cuenta) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.buscarId(cuenta.id());
        if (cuentaOptional.isEmpty()) {
            throw new Exception("No existe la cuenta");
        }
        Cuenta cuentaModificada = cuentaOptional.get();
        if (!existeCedula(cuenta.id())) {
            throw new Exception("No se encontro la cuenta con la cedula registrada" + cuenta.id());
        }
        cuentaModificada.getUser().setNombre(cuenta.nombre());
        cuentaModificada.getUser().setDireccion(cuenta.direccion());
        cuentaModificada.getUser().setTelefono(cuenta.telefono());

        cuentaRepo.save(cuentaModificada);
        return cuentaModificada.getId();
    }

    @Override
    public String eliminarCuenta(String id) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.buscarId(id);
        if (cuentaOptional.isEmpty()) {
            throw new Exception("La cuenta no existe");
        }
        if (!existeCedula(id)) {
            throw new Exception("No se encontro la cuenta:" + id);
        }
        Cuenta cuenta = cuentaOptional.get();
        cuenta.setEstado(EstadoCuenta.ELIMINADA);
        cuentaRepo.save(cuenta);
        return id;

    }


    @Override
    public InfoCuentaDTO obtenerInformacionCuenta(String id) throws Exception {
        Cuenta cuenta = obtenerCuenta(id);
        return new InfoCuentaDTO(
                cuenta.getId(),
                cuenta.getUser().getNombre(),
                cuenta.getUser().getTelefono(),
                cuenta.getUser().getDireccion(),
                cuenta.getEmail()
        );
    }

    private Cuenta obtenerCuenta(String id) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.buscarId(id);

        if (cuentaOptional.isEmpty()) {
            throw new Exception("No existe la cuenta");
        }
        return cuentaOptional.get();

    }

    @Override
    public String enviarCodigoRecuperacionPassword(String correo) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.buscarEmail(correo);

        if (cuentaOptional.isEmpty()) {
            throw new Exception("El correo dado no se encuentra registrado");
        }
        Cuenta cuenta = cuentaOptional.get();
        String codigoValidacion = generarCodigo();


//        cuenta.setCodigoValidacionPassword(new CodigoValidacion(codigoValidacion,
//                LocalDateTime.now()));
        cuentaRepo.save(cuenta);

        return "se ha enviado un correo de validacion";
    }

    @Override
    public String cambiarPassword(CambiarPasswordDTO cambiarPasswordDTO) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.buscarEmail(cambiarPasswordDTO.email());

        if (cuentaOptional.isEmpty()) {
            throw new Exception("El correo dado no esta registrado");
        }
        Cuenta cuenta = cuentaOptional.get();
        CodigoValidacion codigoValidacion = cuenta.getCodigoValidacionPassword();

        if (codigoValidacion.getCodigo().equals(cambiarPasswordDTO.codigoVerificacion())) {
            if (codigoValidacion.getFechaCreacion().
                    plusMinutes(15).isBefore(LocalDateTime.now())) {
                cuenta.setPassword(cambiarPasswordDTO.passwordNueva());
                cuentaRepo.save(cuenta);
                return "contraseña cambiada correctamente";
            } else {
                throw new Exception("El codigo de validacion ya expiro");
            }

        } else {
            throw new Exception("El codigo de validacion es incorrecto");
        }
    }


    @Override
    public TokenDTO iniciarSesion(LoginDTO loginDTO) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentaRepo.buscarEmail(loginDTO.email());

        if (cuentaOptional.isEmpty()) {
            throw new Exception("El correo dado no esta registrado");
        }

        Cuenta cuenta = cuentaOptional.get();

        if (cuenta.getPassword().equals(loginDTO.password())) {
            cuenta.setPassword(loginDTO.password());
            cuentaRepo.save(cuenta);
            return "Token";
        }
        return "";
    }

    @Override
    public List<InfoCuentaDTO> listarCuentas() {
        return null;
    }


    private boolean existeEmail(String email) {
        return cuentaRepo.buscarEmail(email).isPresent();
    }
    private boolean existeCedula(String cedula) {
        return cuentaRepo.buscarId(cedula).isPresent();
    }

    @Override
    public String generarCodigo() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int tam = 10;
        SecureRandom random = new SecureRandom();
        StringBuilder codigo= new StringBuilder(tam);
        for (int i = 0; i < tam; i++) {
            int index = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }
}
