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

    public String crear(ReservaDto booked){
        Reserva newReserva = new Reserva();
        float costo=0;
        if(!usuariosRepositorio.existsById(booked.getDni()) || !habitacionRepositorio.existsById(booked.getCdg_habitacion()) ){
            return "usurio o habitacion no existen";
        }
        // try {
            newReserva.setCliente(usuariosRepositorio.findById(booked.getDni()).get());
            newReserva.setHabitacion(habitacionRepositorio.findById(booked.getCdg_habitacion()).get());
            // costo+=habitacionRepositorio.findById(booked.getCdg_habitacion()).get().getPrecio_noche()*(Integer.valueOf(Date. booked.getFecha_fin()-booked.getFecha_fin()));
            newReserva.setFecha_inicio(booked.getFecha_inicio());
            newReserva.setFecha_fin(booked.getFecha_fin());
            
            Servicio newServicio =new Servicio();

            Alimento newAlimento =new Alimento();
            newAlimento.setDesayuno(booked.isDesayuno());
            newAlimento.setAlmuerzo(booked.isAlmuerzo());
            newAlimento.setCena(booked.isCena());
            

            newServicio.setAlimento(newAlimento);

            Lavanderia newlLavanderia = new Lavanderia();
            newlLavanderia.setCant_prendas(booked.getCantidadPrendas());
            newlLavanderia.setCosto_prendas(3);
            newlLavanderia.setCosto_total(booked.getCantidadPrendas()*3);


            newServicio.setLavanderia(null);

            Transporte newTransporte = new Transporte();
            newTransporte.setCosto(BigDecimal.valueOf(0));
            if(booked.isTransporte()){
                newTransporte.setCosto(BigDecimal.valueOf(50));
            }

            newServicio.setTransporte(newTransporte);

            
            // newReserva.setCosto_total(null);
            
            // newServicio.setTipoServicio();
            newAlimento.setServicio(newServicio);
            newTransporte.setServicio(newServicio);
            newlLavanderia.setServicio(newServicio);

            newServicio.setReserva(newReserva);
            
            newReserva.setServicios(newServicio);
            
            
            
            
            
            reservaRepositorio.save(newReserva);
            
            
            return "Reserva creada Exitosamente";
            
        // } catch (Exception e) {
        //     return "hubo un error";
        // }
    };


    public String borrarReserva(Integer id){
        try {
            if(reservaRepositorio.existsById(id)){
                reservaRepositorio.deleteById(id);
                return "Reserva borrada exitosament";
            }
            return "Reserva no existe";
            
        } catch (Exception e) {
            return "hubo un eror";
        }

    };


    
    
}
