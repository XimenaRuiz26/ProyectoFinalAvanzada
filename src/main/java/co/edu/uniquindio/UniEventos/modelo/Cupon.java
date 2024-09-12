package co.edu.uniquindio.UniEventos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("cupones")
public class Cupon {
    @Id
    String id;
    String nombre;
    String codigo;
    TipoCupon tipo;
    EstadoCupon estado;
    Float descuento;
    LocalDateTime fechaVencimiento;
}
