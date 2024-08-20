package unah.lenguajes._0.proyectofinal.Modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_servicios")
public class Servicio {
    
    @Id
    @Column(name = "cdg_servicio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdgServicio;

    private Float costo;
    
    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "cdg_reserva")
    @JsonIgnore
    private Reserva reserva;



    @OneToOne(mappedBy = "servicio" ,cascade = CascadeType.ALL)
    private Alimento alimento;

    @OneToOne(mappedBy = "servicio",cascade = CascadeType.ALL)
    private Lavanderia lavanderia;

    @OneToOne(mappedBy = "servicio",cascade = CascadeType.ALL)
    private Transporte transporte;

}
