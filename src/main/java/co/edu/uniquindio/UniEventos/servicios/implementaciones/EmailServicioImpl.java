package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.EmailDTO.EmailDTO;
import co.edu.uniquindio.UniEventos.servicios.interfaces.EmailServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServicioImpl implements EmailServicio {
    @Autowired
    private JWTUtils jwtUtils;
    private final JavaMailSender javaMailSender;
    /**
     * envio de correo normal puede servir para notificaciones
     *
     * @param emailDTO
     * @throws Exception
     */
    @Override
    public void enviarCorreo(EmailDTO emailDTO) throws Exception {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.cuerpo(), true);
        helper.setTo(emailDTO.destinatario());
        helper.setFrom("no_reply@dominio.com");
        javaMailSender.send(mensaje);
    }
}
