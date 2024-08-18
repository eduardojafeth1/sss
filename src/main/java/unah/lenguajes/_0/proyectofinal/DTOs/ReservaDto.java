package unah.lenguajes._0.proyectofinal.DTOs;

import java.sql.Date;

import lombok.Data;

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
