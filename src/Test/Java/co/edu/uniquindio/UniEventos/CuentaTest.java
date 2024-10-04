package co.edu.uniquindio.UniEventos;
import co.edu.uniquindio.UniEventos.modelo.Cuenta;
import co.edu.uniquindio.UniEventos.modelo.EstadoCuenta;
import co.edu.uniquindio.UniEventos.modelo.Rol;
import co.edu.uniquindio.UniEventos.modelo.Usuario;
import co.edu.uniquindio.UniEventos.repositorios.CuentaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class CuentaTest {
    @Autowired
    public CuentaRepo cuentaRepo;
    @Test
    public void registrarTest(){
        //Creamos la cuenta con sus propiedades
        Cuenta cuenta = Cuenta.builder()
                .email("juanito@email.com")
                .password("123456")
                .fechaRegistro(LocalDateTime.now())
                .estado(EstadoCuenta.ACTIVA)
                .user(
                        Usuario.builder()
                                .cedula("123")
                                .nombre("Juanito")
                                .direccion("Calle 123")
                                .telefono("121212").build()
                )
                .rol(Rol.CLIENTE).build();
        //Guardamos la cuenta del usuario en la base de datos
        Cuenta cuentaCreada = cuentaRepo.save(cuenta);
        //Verificamos que se haya guardado validando que no sea null
        assertNotNull(cuentaCreada);
    }
}
