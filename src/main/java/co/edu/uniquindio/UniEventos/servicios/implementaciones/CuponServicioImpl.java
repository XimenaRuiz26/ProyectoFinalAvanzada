package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.CuponDTO.CrearCuponDTO;
import co.edu.uniquindio.UniEventos.dto.CuponDTO.EditarCuponDTO;
import co.edu.uniquindio.UniEventos.dto.CuponDTO.InfoCuponDTO;
import co.edu.uniquindio.UniEventos.servicios.interfaces.CuponServicio;
import org.springframework.stereotype.Service;

@Service
public class CuponServicioImpl implements CuponServicio {


    @Override
    public String crearCupones(CrearCuponDTO cuponDTO) {
        return null;
    }

    @Override
    public String actualizarCupon(EditarCuponDTO cuponDTO) {
        return null;
    }

    @Override
    public void borrarCupon(String idCupon) {

    }

    @Override
    public boolean validarCupon(String idCupon, String userId) {
        return false;
    }

    @Override
    public String redimirCupon(String idCupon, String idCliente) {
        return null;
    }

    @Override
    public InfoCuponDTO listarCupones(String idCupon, String idCliente) {
        return null;
    }
}
