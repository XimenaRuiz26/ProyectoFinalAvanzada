package co.edu.uniquindio.UniEventos.modelo;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public class Orden {
    String id;
    ObjectId idUser;
    LocalDateTime fecha;
    List<DetalleOrden> items;
    Pago pago;
    ObjectId idCupon;
    Float total;
    String codigoPasarela;
}
