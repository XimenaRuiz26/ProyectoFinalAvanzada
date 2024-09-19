package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.EmailDTO.EmailDTO;
import co.edu.uniquindio.UniEventos.servicios.interfaces.EmailServicio;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import static org.simplejavamail.config.ConfigLoader.Property.SMTP_PORT;
@Service
public class EmailServicioImpl implements EmailServicio {
    @Override
    @Async
    public void enviarCorreo(EmailDTO emailDTO) throws Exception {
        Email email = EmailBuilder.startingBlank()
                .from("SMTP_USERNAME")
                .to(emailDTO.destinatario())
                .withSubject(emailDTO.asunto())
                .withPlainText(emailDTO.cuerpo())
                .buildEmail();

        try (Mailer mailer = MailerBuilder
                .withSMTPServer("SMTP_HOST", SMTP_PORT.ordinal(), "SMTP_USERNAME", "SMTP_PASSWORD")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer()) {
            mailer.sendMail(email);
        }
    }
}
