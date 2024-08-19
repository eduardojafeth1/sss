package unah.lenguajes._0.proyectofinal.Repositorios;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unah.lenguajes._0.proyectofinal.Modelos.Habitacion;

@Repository
public interface HabitacionRepositorio extends JpaRepository <Habitacion,Integer>{

    @Query(value = "SELECT DISTINCT a FROM Habitacion a LEFT JOIN Reserva b ON a.id = b.habitacion.id WHERE :fechafin < b.fecha_inicio OR :fechainicio > b.fecha_fin Or b.cdgReserva IS NULL")
List<Habitacion> habitacionesDisponibles(@Param("fechainicio") Date  fechainicio, @Param("fechafin") Date fechafin);

}
    
