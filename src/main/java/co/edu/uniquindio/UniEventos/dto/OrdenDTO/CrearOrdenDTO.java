package co.edu.uniquindio.UniEventos.dto.OrdenDTO;

import co.edu.uniquindio.UniEventos.modelo.DetalleOrden;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CrearOrdenDTO(
        @NotNull(message = "El ID del usuario no puede estar vacío")
        String idUsuario,
        @NotEmpty(message = "La lista de items de orden no puede estar vacía")
        List<@NotNull(message = "Los items de orden no pueden ser nulos") DetalleOrden> itemsOrden,
        String codigoCupon
) {
}
