package unah.lenguajes._0.proyectofinal.Servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import unah.lenguajes._0.proyectofinal.DTOs.FiltroFechasDto;
import unah.lenguajes._0.proyectofinal.DTOs.HabitacionDto;
import unah.lenguajes._0.proyectofinal.Modelos.EstadoHabitacion;
import unah.lenguajes._0.proyectofinal.Modelos.Habitacion;
import unah.lenguajes._0.proyectofinal.Modelos.Reserva;
import unah.lenguajes._0.proyectofinal.Repositorios.EstadoHabitacionRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.HabitacionRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.ReservaRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.TipoHabitacionRepositorio;

@Service
public class HabitacionServicio {
    
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;

    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;
    
    @Autowired
    private EstadoHabitacionRepositorio estadoHabitacionRepositorio;
    
    @Autowired
    private ReservaRepositorio reservaRepositorio;
    
    public List<Habitacion> verHabitacion(){
        return habitacionRepositorio.findAll();
    }

    public String crearHabitacion(HabitacionDto habitacion){
        List<Habitacion> habitaciones = habitacionRepositorio.findAll();
        for (Habitacion h : habitaciones) {
            if(h.getPiso() == habitacion.getPiso() && h.getNumero() ==  habitacion.getNumero()){
                 return "La habitacion ya existe";
             } }
        // Habitacion newroom = new Habitacion();
        // newroom=habitacion;
        // habitacionRepositorio.save(newroom);
        // return "habitacion guardada con exito";
    // forma original falta comprimir
        Habitacion newHabitacion = new Habitacion();
        try {
        newHabitacion.setCant_calificaciones(0);
        newHabitacion.setRating(0);
        newHabitacion.setSum_calificaciones(0);
        newHabitacion.setDescripcion(habitacion.getDescripcion());
        newHabitacion.setNumero(habitacion.getNumero());
        newHabitacion.setPiso(habitacion.getPiso());
        newHabitacion.setPrecio_noche(habitacion.getPrecio_noche());

        
            if(tipoHabitacionRepositorio.existsById(habitacion.getTipo())){
                newHabitacion.setTipoHabitacion(tipoHabitacionRepositorio.findById(habitacion.getTipo()).get());
            }
            if (estadoHabitacionRepositorio.existsById(habitacion.getEstado())) {
                
                newHabitacion.setEstadoHabitacion(estadoHabitacionRepositorio.findById(habitacion.getEstado()).get());
            }else{

                newHabitacion.setTipoHabitacion(tipoHabitacionRepositorio.findById(1).get());
                newHabitacion.setEstadoHabitacion(estadoHabitacionRepositorio.findById(1).get());
            }
            

        habitacionRepositorio.save(newHabitacion);

        return "Habitacion Creada con exito";
        }   
 
    catch (Exception e) {
     return "Hubo un error";
        }
        
    
    }
    
    public String editarHabitacion(Integer id,HabitacionDto room){
        try {
            if(habitacionRepositorio.existsById(id)){
                Habitacion habitacion = habitacionRepositorio.findById(id).get();
                if(room.getDescripcion() !=null && !room.getDescripcion().isEmpty()){
                    habitacion.setDescripcion(room.getDescripcion());
                }
                if(estadoHabitacionRepositorio.existsById(room.getEstado())){
                    habitacion.setEstadoHabitacion(estadoHabitacionRepositorio.findById(room.getEstado()).get());
                }
                if(room.getPrecio_noche()>0 ){
                    habitacion.setPrecio_noche(room.getPrecio_noche());
                }
                if(tipoHabitacionRepositorio.existsById(room.getTipo())){
                    habitacion.setTipoHabitacion(tipoHabitacionRepositorio.findById(room.getTipo()).get());
                }

                habitacionRepositorio.save(habitacion);
                return "habitacion actualizada con exito";
            }
            return "habitacion no existe";
        } catch (Exception e) {
            return "Fallo al actualizar habitacion";
        }
        
    };


    public String borrarHabitacion(Integer id){
        try {
            if(habitacionRepositorio.existsById(id)){
        habitacionRepositorio.deleteById(id);
        return "Habitacino borrada exitosamente";
        }
        return "Habitacion no existe";
    }
        catch (Exception e) {
            return "Fallo al borrar habitacion";
        }
    
    };

    public Habitacion buscarHabitacion(Integer id){
        return habitacionRepositorio.findById(id).orElse(null);
    }
    

        public List<Habitacion> filtrarporfecha(FiltroFechasDto fechas) {
            Date fechaInicio = fechas.getFechaInicio();
            Date fechaFin = fechas.getFechafin();
            List<Reserva> reservas = reservaRepositorio.findAll();
            List<Habitacion> habitacionesDisponibles = new ArrayList<>();
            List<Habitacion> todasHabitaciones = habitacionRepositorio.findAll();
    
            habitacionesDisponibles.addAll(todasHabitaciones);
            for (Reserva reserva : reservas) {
                if ((reserva.getFecha_inicio().before(fechaFin) && reserva.getFecha_fin().after(fechaInicio))) {
                    habitacionesDisponibles.removeIf(h -> h.getId().equals(reserva.getHabitacion().getId()));
                }
            }
    
            return habitacionesDisponibles;
        }
    
    
}
    
