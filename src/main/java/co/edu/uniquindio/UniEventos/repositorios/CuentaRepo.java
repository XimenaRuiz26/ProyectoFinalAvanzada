package co.edu.uniquindio.UniEventos.repositorios;
import co.edu.uniquindio.UniEventos.modelo.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepo extends MongoRepository<Cuenta, String> {
    @Query("{email:  ?0}")
    Cuenta buscarEmail(String correo);

    @Query("{id: ?0}")
    boolean buscarId(String id);

    @Query("{email:  ?0}")
    Optional<Cuenta> byFindEmail(String email);

    @Query("{'cedula':  ?0}")
    Optional<Cuenta> byFindCedula(String cedula);

}
