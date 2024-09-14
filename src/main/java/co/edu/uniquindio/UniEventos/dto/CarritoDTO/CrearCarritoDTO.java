package co.edu.uniquindio.UniEventos.dto.CarritoDTO;

import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;

public record CrearCarritoDTO(
        @NotBlank ObjectId idUsuario
) {
}
