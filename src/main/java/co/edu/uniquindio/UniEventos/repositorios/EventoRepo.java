package co.edu.uniquindio.UniEventos.repositorios;

import co.edu.uniquindio.UniEventos.modelo.EstadoEvento;
import co.edu.uniquindio.UniEventos.modelo.Evento;
import co.edu.uniquindio.UniEventos.modelo.TipoEvento;
import co.edu.uniquindio.UniEventos.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepo extends MongoRepository<Evento, String> {
    @Query("{ 'nombre' :?0  }")
    Optional<Evento> buscarPorNombre(String nombre);

    @Query("{'nombre': {$regex: ?0, $options: 'i'}, 'tipo': {$regex: ?1, $options: 'i'}, 'ciudad': {$regex: ?2, $options: 'i'}}")
    List<Evento> filtrarEventos(String nombre, String tipo, String ciudad);

    @Query("{fecha: { $gte: ?0, $lte: ?1 }}")
    List<Evento> buscarPorRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("{tipo: ?0}")
    List<Evento> buscarPorTipo(TipoEvento tipo);

    @Query("{ciudad: ?0}")
    List<Evento> buscarPorCiudad(String ciudad);

    @Query("{alojamientosCercanos: { $exists: true, $not: { $size: 0 } }}")
    List<Evento> buscarConAlojamientosCercanos(String ciudad, String direccion);

}
