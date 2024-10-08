package co.edu.uniquindio.UniEventos.repositorios;

import co.edu.uniquindio.UniEventos.modelo.Orden;
import co.edu.uniquindio.UniEventos.modelo.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenRepo extends MongoRepository<Orden, String> {
    // Buscar todas las órdenes asociadas a un cliente específico
    @Query("{'idUser': { $eq: ObjectId(?0) }}")
    List<Orden> buscarPorUser(String idUser);

    List<Orden> findAllByIdCuenta(String idCuenta);
}
