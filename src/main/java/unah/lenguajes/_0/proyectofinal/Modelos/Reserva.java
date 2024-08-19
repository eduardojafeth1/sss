package unah.lenguajes._0.proyectofinal.Modelos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_reserva")
public class Reserva {

    @Id
    @Column(name= "cdg_reserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdgReserva;

    private Date fecha_inicio;
    private Date fecha_fin;
    private Float costo_total;

    
    @ManyToOne
    @JoinColumn(name = "cliente_dni")
    private Usuarios cliente;

    @ManyToOne
    @JoinColumn(name = "cdg_habitacion")
    private Habitacion habitacion;

    @OneToOne(mappedBy = "reserva", cascade =  CascadeType.ALL)
    private Servicio servicios;
}
