package unah.lenguajes._0.proyectofinal.Modelos;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    
    
    private float rating;
    private Integer cant_calificaciones;
    private Integer sum_calificaciones;

    @ManyToOne
    @JoinColumn(name = "tipo")
    private TipoHabitacion tipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "estado")
    private EstadoHabitacion estadoHabitacion;

    

    
    @OneToMany(mappedBy ="habitacion",cascade =CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Reserva> reservas;
}
