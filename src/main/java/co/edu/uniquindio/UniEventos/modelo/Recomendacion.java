package co.edu.uniquindio.UniEventos.modelo;

import org.bson.types.ObjectId;

import java.util.List;

public class Recomendacion {
    String id;
    ObjectId idUser;
    List<Evento> eventos;
    String motivo;

}
