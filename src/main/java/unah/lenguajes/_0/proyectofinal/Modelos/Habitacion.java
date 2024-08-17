package unah.lenguajes._0.proyectofinal.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tbl_habitaciones")
public class Habitacion {
    
    @Id
    @Column(name = "cdg_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private Integer piso;
    private float precio_noche;
    private String descripcion;
    private float raiting;
    private Integer cant_calificaciones;
    private Integer sum_calificaciones;

    @ManyToOne
    @JoinColumn(name = "tipo")
    private TipoHabitacion tipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoHabitacion estadoHabitacion;
}
