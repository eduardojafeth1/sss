package unah.lenguajes._0.proyectofinal.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes._0.proyectofinal.DTOs.FiltroFechasDto;
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

    @PutMapping("/editar/{id}")
    public String editarHabitacion(@PathVariable("id") int id, @RequestBody HabitacionDto habitacion){
        return habitacionService.editarHabitacion(id, habitacion);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarHabitacion(@PathVariable("id") int id){
        return habitacionService.borrarHabitacion(id);
    }

    @GetMapping("buscar/{id}")
    public Habitacion buscarHabitacion(@PathVariable("id") int id){
        return habitacionService.buscarHabitacion(id);
    }

    @PostMapping("/filtrarfecha")
    public List<Habitacion> filtrHabitacions(@RequestBody FiltroFechasDto fechas){
        return habitacionService.filtrarporfecha(fechas);
    }


}
