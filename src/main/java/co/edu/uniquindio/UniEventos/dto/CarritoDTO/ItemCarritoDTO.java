package co.edu.uniquindio.UniEventos.dto.CarritoDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public record ItemCarritoDTO(
        @Min(value = 1, message = "La cantidad debe ser al menos 1")
        int cantidad,
        @NotBlank(message = "El nombre de la localidad no puede estar vacío")
        String nombreLocalidad,
        @NotBlank(message = "El ID del evento es obligatorio")
        String idEvento,
        @NotNull(message = "La fecha de agregación es obligatoria")
        @PastOrPresent(message = "La fecha de agregación no puede ser en el futuro")
        LocalDateTime fechaAgregacion
) {
}
