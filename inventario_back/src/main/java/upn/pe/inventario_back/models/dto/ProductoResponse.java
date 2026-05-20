package upn.pe.inventario_back.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResponse {
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    private String unidad_medida;
    private Long categoria_id;
    private Long linea_id;
}