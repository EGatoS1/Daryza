package upn.pe.inventario_back.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KardexResponse {

    private String id;
    private LocalDateTime fecha;
    private Integer cantidad;
    private Integer stockActual;
    private UsuarioResponse usuario;
}
