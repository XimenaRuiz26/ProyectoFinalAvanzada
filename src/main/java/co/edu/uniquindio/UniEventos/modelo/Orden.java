package co.edu.uniquindio.UniEventos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("ordenes")
public class Orden {
    @Id
    String id;
    ObjectId idUser;
    LocalDateTime fecha;
    List<DetalleOrden> items;
    Pago pago;
    ObjectId idCupon;
    Float total;
    String codigoPasarela;
}
