package co.edu.uniquindio.UniEventos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("pagos")
public class Pago {
    @Id
    String id;
    LocalDateTime fecha;
    String tipoPago;
    String moneda;
    String detalleEstado;
    String estado;
    String codigoAutorizacion;
    Float valorTransaccion;

}
