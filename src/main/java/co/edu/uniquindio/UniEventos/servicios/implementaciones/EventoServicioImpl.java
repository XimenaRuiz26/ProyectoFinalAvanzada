package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.EventoDTO.*;
import co.edu.uniquindio.UniEventos.excepciones.EventoException;
import co.edu.uniquindio.UniEventos.modelo.EstadoEvento;
import co.edu.uniquindio.UniEventos.modelo.Evento;
import co.edu.uniquindio.UniEventos.modelo.Localidad;
import co.edu.uniquindio.UniEventos.modelo.TipoEvento;
import co.edu.uniquindio.UniEventos.repositorios.EventoRepo;
import co.edu.uniquindio.UniEventos.servicios.interfaces.EventoServicio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventoServicioImpl implements EventoServicio {
    EventoRepo eventoRepo;
    public String crearEvento(CrearEventoDTO crearEventoDTO) throws EventoException {
        if (existeNombre(crearEventoDTO.nombre())) {
            throw new EventoException("El nombre ya existe, elija otro nombre");
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
        List<Localidad> localidades = crearLocalidades(crearEventoDTO.localidades());
        evento.setLocalidades(localidades);
        Evento eventoCreado = eventoRepo.save(evento);
        return eventoCreado.getId();
    }

    private List<Localidad> crearLocalidades(List<LocalidadDTO> listaLocalidadesDTO) {
        List<Localidad> localidades = new ArrayList<>(listaLocalidadesDTO.size());
        for (LocalidadDTO crearLocalidadDTO : listaLocalidadesDTO) {
            Localidad localidad = new Localidad(
                    crearLocalidadDTO.nombre(),
                    crearLocalidadDTO.aforo(),
                    crearLocalidadDTO.precio()
            );
            localidades.add(localidad);
        }
        return localidades;
    }

    @Override
    public String editarEvento(EditarEventoDTO editarEventoDTO) throws EventoException {
        Optional<Evento> optionalEvento = eventoRepo.findById(editarEventoDTO.id());
        if (optionalEvento.isEmpty()) {
            throw new EventoException("No existe este evento");
        }
        Evento eventoModificado = optionalEvento.get();
        eventoModificado.setImagenPortada(editarEventoDTO.imagenPoster());
        eventoModificado.setNombre(editarEventoDTO.nombre());
        eventoModificado.setDescripcion(editarEventoDTO.descripcion());
        eventoModificado.setDireccion(editarEventoDTO.direccion());
        eventoModificado.setImagenLocalidad(editarEventoDTO.imagenLocalidades());
        eventoModificado.setTipo(editarEventoDTO.tipo());
        eventoModificado.setEstado(editarEventoDTO.estado());
        eventoModificado.setFecha(editarEventoDTO.fecha());
        eventoModificado.setCiudad(editarEventoDTO.ciudad());

        List<Localidad> localidadesActualizadas = modificarLocalidades(eventoModificado.getLocalidades(),editarEventoDTO.localidades());
        eventoModificado.setLocalidades(localidadesActualizadas);

        eventoRepo.save(eventoModificado);
        return null;
    }

    private List<Localidad> modificarLocalidades(List<Localidad> localidadesActuales ,List<LocalidadDTO> listaLocalidadesDTO) throws EventoException {

        List<Localidad> localidadesActualizadas = new ArrayList<>(localidadesActuales);
        if(!localidadesActuales.isEmpty()) {
            for (LocalidadDTO localidadDTO : listaLocalidadesDTO) {
                for (Localidad localidad : localidadesActuales) {
                    if (localidad.getNombre().equals(localidadDTO.nombre())) {
                        localidad.setNombre(localidadDTO.nombre());
                        localidad.setAforo(localidadDTO.aforo());
                        localidad.setPrecio(localidadDTO.precio());
                    }
                }
            }
        }else{
            throw new EventoException("La localidad que intentas editar no existe");
        }
        return localidadesActualizadas;
    }

    @Override
    public String eliminarEvento(String id) throws EventoException {
        Optional<Evento> optionalEvento = eventoRepo.findById(id);
        if(optionalEvento.isEmpty()){
            throw new EventoException("No se encontro el evento");
        }else if (optionalEvento.get().getEstado().equals(EstadoEvento.INACTIVO)) {
            throw new EventoException("El evento ya se encuentra inactivo");
        }
        Evento evento = optionalEvento.get();
        evento.setEstado(EstadoEvento.INACTIVO);
        eventoRepo.save(evento);
        return id;
    }

    @Override
    public InfoEventoDTO obtenerInformacionEvento(String id) throws EventoException {
        Evento evento = eventoRepo.findById(id)
                .orElseThrow(() -> new EventoException("No se ha encontrado el evento"));
        return new InfoEventoDTO(
                evento.getImagenPortada(),
                evento.getNombre(),
                evento.getDescripcion(),
                evento.getDireccion(),
                evento.getTipo(),
                evento.getFecha(),
                evento.getCiudad(),
                evento.getLocalidades(),
                evento.getAlojamientosCercanos()
        );
    }

    @Override
    public List<ItemEventoDTO> listarEventos() {
        List<Evento> eventos = eventoRepo.findAll();
        List<ItemEventoDTO> respuesta = new ArrayList<>();

        for(Evento evento : eventos){
            respuesta.add(new ItemEventoDTO(
                    evento.getImagenPortada(),
                    evento.getNombre(),
                    evento.getFecha(),
                    evento.getDireccion(),
                    evento.getTipo()
            ));
        }
        return respuesta;
    }

    @Override
    public List<ItemEventoDTO> filtrarEventos(FiltroEventoDTO filtroEventoDTO) {
        List<ItemEventoDTO> respuesta = new ArrayList<>();
        List<Evento> eventos= eventoRepo.filtrarEventos(filtroEventoDTO.nombre(),filtroEventoDTO.tipoEvento().toString(), filtroEventoDTO.ciudad());
        for(Evento evento : eventos){
            respuesta.add(new ItemEventoDTO(
                    evento.getImagenPortada(),
                    evento.getNombre(),
                    evento.getFecha(),
                    evento.getDireccion(),
                    evento.getTipo()
            ));
        }
        return respuesta;
    }

    @Override
    public List<FiltroEventoDTO> filtrarPorTipo(TipoEvento tipoEvento) {
        List<Evento> eventos = eventoRepo.buscarPorTipo(tipoEvento);
        if (eventos.isEmpty()) {
            throw new EventoException("No se encontraron eventos para el tipo de evento: " + tipoEvento);
        }
        List<FiltroEventoDTO> eventoFiltradoDTO = new ArrayList<>();

        for(Evento evento : eventos){
            eventoFiltradoDTO.add(new FiltroEventoDTO(
                    evento.getImagenPortada(),
                    evento.getNombre(),
                    evento.getDireccion(),
                    evento.getCiudad(),
                    evento.getFecha(),
                    evento.getTipo(),
                    evento.getLocalidades()
            ));
        }
        return eventoFiltradoDTO;
    }


    @Override
    public List<FiltroEventoDTO> filtrarPorFecha(LocalDate fecha) {
        List<Evento> eventos = eventoRepo.buscarPorRangoDeFechas(fecha.atStartOfDay(), fecha.plusDays(1).atStartOfDay());
        if (eventos.isEmpty()) {
            throw new EventoException("No se encontraron eventos para la fecha: " + fecha);
        }
        List<FiltroEventoDTO> eventoFiltradoDTO = new ArrayList<>();
        for(Evento evento : eventos){
            eventoFiltradoDTO.add(new FiltroEventoDTO(
                    evento.getImagenPortada(),
                    evento.getNombre(),
                    evento.getDireccion(),
                    evento.getCiudad(),
                    evento.getFecha(),
                    evento.getTipo(),
                    evento.getLocalidades()
            ));
        }
        return eventoFiltradoDTO;
    }

    @Override
    public List<FiltroEventoDTO> filtrarPorCiudad(String ciudad) {
        List<Evento> eventos = eventoRepo.buscarPorCiudad(ciudad);
        if (eventos.isEmpty()) {
            throw new EventoException("No se encontraron eventos para la ciudad: " + ciudad);
        }
        List<FiltroEventoDTO> eventoFiltradoDTO = new ArrayList<>();
        for(Evento evento : eventos){
            eventoFiltradoDTO.add(new FiltroEventoDTO(
                    evento.getImagenPortada(),
                    evento.getNombre(),
                    evento.getDireccion(),
                    evento.getCiudad(),
                    evento.getFecha(),
                    evento.getTipo(),
                    evento.getLocalidades()
            ));
        }
        return eventoFiltradoDTO;
    }

    @Override
    public List<FiltroEventoDTO> filtrarPorAlojamientosCercanos(String ciudad, String direccion) {
        List<Evento> eventos = eventoRepo.buscarConAlojamientosCercanos(ciudad, direccion);
        if (eventos.isEmpty()) {
            throw new EventoException("No se encontraron alojamientos cercanos al evento");
        }
        List<FiltroEventoDTO> eventoFiltradoDTO = new ArrayList<>();
        for(Evento evento : eventos){
            eventoFiltradoDTO.add(new FiltroEventoDTO(
                    evento.getImagenPortada(),
                    evento.getNombre(),
                    evento.getDireccion(),
                    evento.getCiudad(),
                    evento.getFecha(),
                    evento.getTipo(),
                    evento.getLocalidades()
            ));
        }
        return eventoFiltradoDTO;
    }

    @Override
    public List<FiltroEventoDTO> filtrarPorRangoDeFechas(LocalDateTime desde, LocalDateTime hasta) {
        List<Evento> eventos = eventoRepo.buscarPorRangoDeFechas(desde, hasta);
        if (eventos.isEmpty()) {
            throw new EventoException("No se encontraron eventos en el rango de fechas: " + desde + " a " + hasta);
        }
        List<FiltroEventoDTO> eventoFiltradoDTO = new ArrayList<>();
        for(Evento evento : eventos){
            eventoFiltradoDTO.add(new FiltroEventoDTO(
                    evento.getImagenPortada(),
                    evento.getNombre(),
                    evento.getDireccion(),
                    evento.getCiudad(),
                    evento.getFecha(),
                    evento.getTipo(),
                    evento.getLocalidades()
            ));
        }
        return eventoFiltradoDTO;
    }
    @Override
    public Evento obtenerEvento(String id) throws EventoException {
        return eventoRepo.findById(id).orElseThrow( () -> new EventoException("El evento no existe") );
    }

    @Override
    public List<Evento> getAll() {
        return eventoRepo.findAll();
    }

    public boolean existeNombre(String nombre){
        return eventoRepo.buscarPorNombre(nombre).isPresent();
    }

}
