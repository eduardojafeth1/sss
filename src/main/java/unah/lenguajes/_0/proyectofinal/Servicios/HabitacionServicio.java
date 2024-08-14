package unah.lenguajes._0.proyectofinal.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes._0.proyectofinal.Modelos.Habitacion;
import unah.lenguajes._0.proyectofinal.Repositorios.HabitacionRepositorio;

@Service
public class HabitacionServicio {
    
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;

    public List<Habitacion> verHabitacion(){
        return habitacionRepositorio.findAll();
    }

}
