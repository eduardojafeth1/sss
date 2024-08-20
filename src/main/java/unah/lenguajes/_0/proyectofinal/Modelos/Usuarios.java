package unah.lenguajes._0.proyectofinal.Modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_clientes")
public class Usuarios {
    
    @Id
    @Column(name = "dni")
    private String dni;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String contrasena;
    
    private Integer tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)

    private List<Reserva> reservas;
}
