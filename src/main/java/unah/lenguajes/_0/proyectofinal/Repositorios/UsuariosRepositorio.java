package unah.lenguajes._0.proyectofinal.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes._0.proyectofinal.Modelos.Usuarios;

@Repository
public interface UsuariosRepositorio extends JpaRepository <Usuarios, String> {
 
    
}
