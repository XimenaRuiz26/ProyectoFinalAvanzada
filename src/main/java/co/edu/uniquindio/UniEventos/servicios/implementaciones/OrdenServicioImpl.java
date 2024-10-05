package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.OrdenDTO.CrearOrdenDTO;
import co.edu.uniquindio.UniEventos.dto.OrdenDTO.InfoOrdenDTO;
import co.edu.uniquindio.UniEventos.excepciones.CuentaException;
import co.edu.uniquindio.UniEventos.excepciones.OrdenException;
import co.edu.uniquindio.UniEventos.servicios.interfaces.OrdenServicio;
import com.mercadopago.resources.preference.Preference;

import java.util.List;
import java.util.Map;

public class OrdenServicioImpl implements OrdenServicio {
    @Override
    public String crearOrden(CrearOrdenDTO crearOrdenDTO) throws Exception {
        return null;
    }

    @Override
    public String cancelarOrden(String ordenId) throws Exception {
        return null;
    }

    @Override
    public InfoOrdenDTO obtenerInfoOrden(String ordenId) throws OrdenException, Exception {
        return null;
    }

    @Override
    public List<InfoOrdenDTO> listarOrdenesCliente(String userId) throws OrdenException, CuentaException, Exception {
        return null;
    }

    @Override
    public Preference realizarPago(String ordenId) throws Exception {
        return null;
    }

    @Override
    public void recibirNotificacionMercadoPago(Map<String, Object> request) {

    }
}
