package unah.lenguajes._0.proyectofinal.DTOs;

import lombok.Data;

@Data
public class HabitacionDto {
    
        private Integer numero;
    private Integer piso;
    private float precio_noche;
    private String descripcion;
    private Integer tipo;
    private Integer estado;

}
