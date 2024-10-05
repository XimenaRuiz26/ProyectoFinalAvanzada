package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.OrdenDTO.CrearOrdenDTO;
import co.edu.uniquindio.UniEventos.dto.OrdenDTO.InfoOrdenDTO;
import co.edu.uniquindio.UniEventos.excepciones.CuentaException;
import co.edu.uniquindio.UniEventos.excepciones.OrdenException;
import co.edu.uniquindio.UniEventos.modelo.Orden;
import com.mercadopago.resources.preference.Preference;

import java.util.List;
import java.util.Map;

public interface OrdenServicio {
    String crearOrden(CrearOrdenDTO crearOrdenDTO) throws Exception;
    String cancelarOrden(String ordenId) throws Exception;
    InfoOrdenDTO obtenerInfoOrden(String ordenId) throws OrdenException, Exception;;
    List<InfoOrdenDTO> listarOrdenesCliente(String userId) throws OrdenException, CuentaException, Exception;

    //pago
    Preference realizarPago(String ordenId) throws Exception;
    void recibirNotificacionMercadoPago(Map<String, Object> request);

}
