package unah.lenguajes._0.proyectofinal.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "tbl_alimentos")
@Entity
public class Alimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdg_alimentos")
    private Integer id;
    
    private Boolean desayuno;
    private Boolean almuerzo;
    private Boolean cena;

@ManyToOne
    @JoinColumn(name = "cdg_servicio")
    @JsonIgnore
    private Servicio servicio;


    
}
