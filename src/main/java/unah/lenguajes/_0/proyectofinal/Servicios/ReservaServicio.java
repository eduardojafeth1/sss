package unah.lenguajes._0.proyectofinal.Servicios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes._0.proyectofinal.DTOs.ReservaDto;
import unah.lenguajes._0.proyectofinal.Modelos.Alimento;
import unah.lenguajes._0.proyectofinal.Modelos.Lavanderia;
import unah.lenguajes._0.proyectofinal.Modelos.Reserva;
import unah.lenguajes._0.proyectofinal.Modelos.Servicio;
import unah.lenguajes._0.proyectofinal.Modelos.Transporte;
import unah.lenguajes._0.proyectofinal.Repositorios.AlimentoRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.HabitacionRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.LavanderiaRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.ReservaRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.ServicioRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.TransporteRepositorio;
import unah.lenguajes._0.proyectofinal.Repositorios.UsuariosRepositorio;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    @Autowired
    private HabitacionRepositorio habitacionRepositorio;

    @Autowired
    private TransporteRepositorio transporteRepositorio;
    
    @Autowired
    private LavanderiaRepositorio lavanderiaRepositorio;

    @Autowired
    private AlimentoRepositorio alimentoRepositorio;

    @Autowired
    private ServicioRepositorio servicioRepositorio;

    public String crearReserva(ReservaDto reserva){
         try {

            Alimento alimento =new Alimento();
            Transporte transporte =new Transporte();
            Lavanderia lavanderia =new Lavanderia();
            
            Servicio servicio =new Servicio();
            
            Reserva newReserva = new Reserva();
            newReserva.setCliente(usuariosRepositorio.findById(reserva.getDni()).get());
            newReserva.setHabitacion(habitacionRepositorio.findById(reserva.getCdg_habitacion()).get());
            newReserva.setFecha_fin(reserva.getFecha_fin());
            newReserva.setFecha_inicio(reserva.getFecha_inicio());
            float costo = reservaRepositorio.findById(reserva.getCdg_habitacion()).get().getCosto_total() ;
            if (reserva.isTransporte()) {
                transporte.setCosto(BigDecimal.valueOf(50.00));
                costo+=50;
            }
            if(reserva.isAlmuerzo()){
                costo+=25;
                alimento.setAlmuerzo(true);
            }
            
            if(reserva.isDesayuno()){
                
                costo+=25;
                alimento.setDesayuno(true);
            }
            
            if(reserva.isCena()){
                costo+=25;
                alimento.setCena(true);
            }
            lavanderia.setCosto_prendas(3);
            lavanderia.setCant_prendas(reserva.getCantidadPrendas());
            lavanderia.setCosto_total(reserva.getCantidadPrendas()*3);
            costo+=(reserva.getCantidadPrendas()*3);
            
            servicio.setCosto(costo);

            costo+=(habitacionRepositorio.findById(reserva.getCdg_habitacion()).get().getPrecio_noche());
            
            newReserva.setCosto_total(costo);
            reservaRepositorio.save(newReserva);

            servicio.setReserva(newReserva);
            servicioRepositorio.save(servicio);

             alimento.setServicio(servicio);
             alimentoRepositorio.save(alimento);

             lavanderia.setServicio(servicio);
             lavanderiaRepositorio.save(lavanderia);

             transporte.setServicio(servicio);
             transporteRepositorio.save(transporte);
            return "Reserva Creada con exito";
        } catch (RuntimeException e) {
            return "hubo un error al crear reserva";
        }
        
        // try {
        //     if(usuariosRepositorio.existsById(reserva.getDni()) && habitacionRepositorio.existsById(reserva.getCdg_habitacion())){

        //         return "hola";
        //     }
            
        // } catch (Exception e) {
        //      return "error";
        // }
        // return null;
    }
    
}
