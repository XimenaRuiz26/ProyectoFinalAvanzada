package co.edu.uniquindio.UniEventos.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("cupones")
public class Cupon {
    String nombre;
    String codigo;
    TipoCupon tipo;
    EstadoCupon estado;
    Float descuento;
    LocalDateTime fechaVencimiento;
}
