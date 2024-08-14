package unah.lenguajes._0.proyectofinal.Modelos;

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
@Table(name = "tbl_lavanderia")
public class Lavanderia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdgLavanderia;

    private Integer Cant_prendas;
    private float costo_prendas ;
    private float costo_total ;


    @ManyToOne
    @JoinColumn(name = "cdg_servicio")
    private Servicio servicio;
    
    
}
