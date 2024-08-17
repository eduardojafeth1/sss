package unah.lenguajes._0.proyectofinal.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_tipo_habitacion")
public class TipoHabitacion {

    @Id
    @Column(name = "cdg_tipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdgTipo;

    private String tipo;
}
