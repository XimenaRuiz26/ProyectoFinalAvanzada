package co.edu.uniquindio.UniEventos.repositorios;

import co.edu.uniquindio.UniEventos.modelo.Cupon;
import co.edu.uniquindio.UniEventos.modelo.TipoCupon;
import co.edu.uniquindio.UniEventos.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CuponRepo extends MongoRepository<Cupon, String> {
    @Query("{ codigo : ?0 }")
    Optional<Cupon> buscarCuponPorCodigo(String codigo);
    @Query(" {fechaVencimiento: { $gt: new Date() }}")
    Optional<Cupon> obtenerCuponesDisponibles();

    @Query("{nombre: ?0}")
    Optional<Cupon> buscarPorNombre(String nombre);

    @Query(" {fechaVencimiento: { $lt: new Date() }}")
    Optional<Cupon> obtenerCuponesExpirados();

    @Query("{nombre: ?0, tipo: ?1}")
    Optional<Cupon> buscarPorNombreYTipo(String nombre, TipoCupon tipo);

    @Query(" $or [{nombre: ?0}, {descuento: ?1}, {fechaExpiracion: ?2}, {tipo: ?3}]")
    Optional<Cupon> buscarCupon(String nombre, float descuento, LocalDateTime fechaExpiracion, TipoCupon tipo);


}
