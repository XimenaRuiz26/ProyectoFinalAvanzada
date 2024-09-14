package co.edu.uniquindio.UniEventos.dto.CarritoDTO;

import co.edu.uniquindio.UniEventos.modelo.DetalleCarrito;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record ActualizarCarritoDTO(
        @Length(min = 1, message = "El carrito debe contener eventos") List<DetalleCarrito> items,
        @NotBlank(message = "La fecha no se encuentra") LocalDateTime fecha,
        @NotBlank(message = "No se ingreso el id") String id,
        @NotBlank ObjectId idUser
) {
}
