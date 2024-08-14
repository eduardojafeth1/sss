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

@Data
@Entity
@Table(name = "tbl_transporte")
public class Transporte {
    
    @Id
    @Column(name = "cdg_transporte")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdgTransporte;

    private Float costo;

     @ManyToOne
    @JoinColumn(name = "cdg_servicio")
    private Servicio servicio;
    
}
