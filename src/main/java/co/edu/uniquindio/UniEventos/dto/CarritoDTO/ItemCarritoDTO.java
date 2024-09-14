package co.edu.uniquindio.UniEventos.dto.CarritoDTO;

import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;

public record ItemCarritoDTO(
        @NotBlank ObjectId idUsuario
) {
}
