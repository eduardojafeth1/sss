package unah.lenguajes._0.proyectofinal.DTOs;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import unah.lenguajes._0.proyectofinal.Modelos.Habitacion;
import unah.lenguajes._0.proyectofinal.Modelos.Servicio;
import unah.lenguajes._0.proyectofinal.Modelos.Usuarios;

@Data
public class ReservaDto {

    private Date fecha_inicio;
    private Date fecha_fin;

    private String dni;
    private Integer cdg_habitacion;

    // @OneToMany(mappedBy = "reserva")
    //  private List<Servicio> servicios;

    private boolean transporte; 
    private boolean desayuno;
    private boolean almuerzo;
    private boolean cena;
    private Integer cantidadPrendas;
    
}
