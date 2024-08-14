package unah.lenguajes._0.proyectofinal.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_tipo_servicios")
public class TipoServicio {

    @Id
    @Column(name = "cdg_tipo_servicio")
    private Integer cdgTipo;

    private String nombre_servicio ;
    
}
