package unah.lenguajes._0.proyectofinal.Modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    @OneToOne
    @JoinColumn(name = "cdg_reserva")
    private Reserva reserva;

    // @ManyToOne
    // @JoinColumn(name = "cdg_tipo_servicio")
    // private TipoServicio tipoServicio;

    @OneToOne(mappedBy = "servicio" ,cascade = CascadeType.ALL)
    private Alimento alimento;

    @OneToOne(mappedBy = "servicio",cascade = CascadeType.ALL)
    private Lavanderia lavanderia;

    @OneToOne(mappedBy = "servicio",cascade = CascadeType.ALL)
    private Transporte transporte;

}
