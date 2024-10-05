package co.edu.uniquindio.UniEventos.servicios.implementaciones;

import co.edu.uniquindio.UniEventos.dto.EmailDTO.EmailDTO;
import co.edu.uniquindio.UniEventos.servicios.implementaciones.Utils.EmailPlantillas;
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
                .from("unieventos.boomticket@gmail.com")
                .to(emailDTO.destinatario())
                .withSubject(emailDTO.asunto())
                .withPlainText(emailDTO.cuerpo())
                .buildEmail();

        try (Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "unieventos.boomticket@gmail.com", "wqou zcfn fbcn gbtx")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer()) {
            mailer.sendMail(email);
        }
    }

    @Override
    public void enviarCodigoActivacion(String email, String codigoActivacion) throws Exception {
        String mensaje = EmailPlantillas.obtenerMensajeCodigoValidacion(codigoActivacion);
        enviarCorreo(new EmailDTO(email, "Le damos la bienvenida a Uni Eventos. ¡Activa tu cuenta y asegura tu lugar en los eventos más emocionantes! \uD83C\uDF9F\uFE0F", mensaje));
    }

    @Override
    public void enviarCodigoPassword(String email, String codigoPassword) throws Exception {
        String mensaje = EmailPlantillas.obtenerMensajeRecuperacionPass(codigoPassword);
        enviarCorreo(new EmailDTO(email, "¡Tu código de restablecimiento está aquí! Cambia tu contraseña ahora \uD83D\uDD10", mensaje));
    }

    @Override
    public void enviarCuponBienvenida(String email, String codigoCupon) throws Exception {
        String mensaje = EmailPlantillas.obtenerMensajeCuponBienvenida(codigoCupon);
        enviarCorreo(new EmailDTO(email, "¡Gracias por registrarte! Aquí tienes un 15% de descuento para cualquier evento \uD83C\uDF81", mensaje));
    }

    @Override
    public void enviarCuponCompra(String email, String codigoCupon) throws Exception {
        String mensaje = EmailPlantillas.obtenerMensajeCuponCompra(codigoCupon);
        enviarCorreo(new EmailDTO(email, "¡Gracias por tu compra! Aquí tienes un 10% de descuento en tu próxima entrada \uD83C\uDF81", mensaje));
    }
}
