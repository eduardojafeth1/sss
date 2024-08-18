package unah.lenguajes._0.proyectofinal.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes._0.proyectofinal.Modelos.Alimento;

@Repository
public interface AlimentoRepositorio extends JpaRepository<Alimento,Integer>{
    
}
