package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.CarritoDTO.ActualizarCarritoDTO;
import co.edu.uniquindio.UniEventos.dto.CarritoDTO.CrearCarritoDTO;
import co.edu.uniquindio.UniEventos.dto.CarritoDTO.ItemCarritoDTO;
import co.edu.uniquindio.UniEventos.modelo.Carrito;
import co.edu.uniquindio.UniEventos.modelo.DetalleCarrito;

import java.util.List;

public interface CarritoServicio {
    void añadirItemAlCarrito(String cuentaId, ItemCarritoDTO itemCarritoDTO) throws Exception;

    void removeItemFromCart(String accountId,  String eventId) throws Exception;

    Carrito crearCarrito(CrearCarritoDTO carritoDTO)throws Exception;

    void actualizarCarrito(String cuentaId, ActualizarCarritoDTO actualizarCarritoDTO) throws Exception;

    void limpiarCarrito(String cuentaId) throws Exception;

    List<DetalleCarrito> obtenerDetalleCarrito(String cuentaId) throws Exception;
}
