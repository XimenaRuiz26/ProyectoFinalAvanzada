package co.edu.uniquindio.UniEventos.modelo;

import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public class Carrito {
    ObjectId idUser;
    LocalDateTime fecha;
    List<DetalleCarrito> items;

}
