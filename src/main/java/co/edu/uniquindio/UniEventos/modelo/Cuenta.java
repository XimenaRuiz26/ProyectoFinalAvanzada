package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("cuentas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
public class Cuenta {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private Usuario user;
    private String password;
    private String email;
    private Rol rol;
    private EstadoCuenta estado;
    private LocalDateTime fechaRegistro;
    private CodigoValidacion codigoValidacionRegistro;
    private CodigoValidacion codigoValidacionPassword;
    private List<String> busquedasEventos;
}
