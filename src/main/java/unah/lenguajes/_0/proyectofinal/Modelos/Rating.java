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
@Table(name = "tbl_raiting")
public class Rating {

    @Id
    @Column(name = "cdg_raiting")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdgRaiting;

    @ManyToOne
    @JoinColumn(name = "cdg_reserva")
    private Reserva reserva;

    
}
