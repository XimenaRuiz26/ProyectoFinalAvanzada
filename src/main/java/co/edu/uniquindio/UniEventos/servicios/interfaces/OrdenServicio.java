package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.OrdenDTO.InfoOrdenDTO;
import co.edu.uniquindio.UniEventos.modelo.Orden;

import java.util.List;

public interface OrdenServicio {
    // Crear una nueva orden
    Orden crearOrden(InfoOrdenDTO ordenDTO) throws Exception;

    // Actualizar una orden existente
    Orden actualizarOrder(String ordenId, InfoOrdenDTO updatedOrderDTO ) throws Exception;

    // Eliminar una orden
    void eliminarOrden(String ordenId) throws Exception;

    // Obtener una orden por su ID
    Orden obtenerOrdenId(String ordenId) throws Exception;

    // Listar todas las órdenes de una cuenta específica
    List<Orden> listarOrdenesCuenta(String cuentaId ) throws Exception;

    // Listar todas las órdenes
    List<Orden> listarOrdenes() throws Exception;
}
