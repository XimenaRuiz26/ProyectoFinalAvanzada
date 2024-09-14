package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.EventoDTO.*;
import co.edu.uniquindio.UniEventos.modelo.Evento;
import co.edu.uniquindio.UniEventos.repositorios.EventoRepo;
import co.edu.uniquindio.UniEventos.servicios.interfaces.EventoServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EventoServicioImpl implements EventoServicio {
    EventoRepo eventoRepo;
    public String crearEvento(CrearEventoDTO crearEventoDTO) throws Exception {
        if (existeNombre(crearEventoDTO.nombre())) {
            throw new Exception("El nombre ya existe, elija otro nombre");
        }
        Evento evento = new Evento();
        evento.setNombre(crearEventoDTO.nombre());
        evento.setDescripcion(crearEventoDTO.descripcion());
        evento.setDireccion(crearEventoDTO.direccion());
        evento.setCiudad(crearEventoDTO.ciudad());
        evento.setImagenPortada(crearEventoDTO.imagenPortada());
        evento.setImagenLocalidad(crearEventoDTO.imagenLocalidad());
        evento.setTipo(crearEventoDTO.tipo());
        evento.setFecha(crearEventoDTO.fecha());
        evento.setLocalidades(crearEventoDTO.localidades());
        eventoRepo.save(evento);
        return evento.getId();
    }

    @Override
    public String editarEvento(EditarEventoDTO editarEventoDTO) throws Exception {
        return null;
    }

    @Override
    public String eliminarEvento(String id) throws Exception {
        return null;
    }

    @Override
    public InfoEventoDTO obtenerInformacionEvento(String id) throws Exception {
        return null;
    }

    @Override
    public List<ItemEventoDTO> listarEventos() {
        return null;
    }

    @Override
    public List<ItemEventoDTO> filtrarEventos(FiltroEventoDTO filtroEventoDTO) {
        return null;
    }

    public boolean existeId(String id){
        return eventoRepo.findById(id).isPresent();
    }
    public boolean existeNombre(String nombre){
        return eventoRepo.buscarPorNombre(nombre).isPresent();
    }

}
