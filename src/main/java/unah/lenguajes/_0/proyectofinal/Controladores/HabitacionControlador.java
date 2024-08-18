package unah.lenguajes._0.proyectofinal.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes._0.proyectofinal.DTOs.HabitacionDto;
import unah.lenguajes._0.proyectofinal.Modelos.Habitacion;
import unah.lenguajes._0.proyectofinal.Servicios.HabitacionServicio;

@RestController
@RequestMapping("/habitacion")
public class HabitacionControlador {
    
    @Autowired
    private HabitacionServicio habitacionService;

    @GetMapping("/ver")
    public List<Habitacion> getHabitaciones(){
        return habitacionService.verHabitacion();
    }

    @PostMapping("/crear")
    public String crearHabitacion(@RequestBody  HabitacionDto habitacion){
        return habitacionService.crearHabitacion(habitacion);}
}
