package co.edu.uniquindio.UniEventos.modelo;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
