package unah.lenguajes._0.proyectofinal.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes._0.proyectofinal.DTOs.HabitacionDto;
import unah.lenguajes._0.proyectofinal.Modelos.Habitacion;
import unah.lenguajes._0.proyectofinal.Repositorios.HabitacionRepositorio;

@Service
public class HabitacionServicio {
    
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;

    public List<Habitacion> verHabitacion(){
        return habitacionRepositorio.findAll();
    }

    public String crearHabitacion(HabitacionDto habitacion){
        // List<Habitacion> habitaciones = habitacionRepositorio.findAll();
        // for (Habitacion h : habitaciones) {
        //     if(h.getPiso() == habitacion.getPiso() && h.getNumero() ==  habitacion.getNumero()){
        //         return "La habitacion ya existe";
        //     }
        // }
        // Habitacion newroom = new Habitacion();
        // newroom=habitacion;
        // habitacionRepositorio.save(newroom);
        // return "habitacion guardada con exito";
    // forma original falta comprimir

    return "si funciona";
    
    }
}
