package co.edu.uniquindio.UniEventos.servicios.interfaces;

import co.edu.uniquindio.UniEventos.dto.EmailDTO.EmailDTO;

public interface EmailServicio {
    void enviarCorreo(EmailDTO emailDTO) throws Exception;
}
