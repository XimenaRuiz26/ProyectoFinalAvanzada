package co.edu.uniquindio.UniEventos.repositorios;

import co.edu.uniquindio.UniEventos.modelo.Orden;
import co.edu.uniquindio.UniEventos.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepo extends MongoRepository<Orden, String> {
}
