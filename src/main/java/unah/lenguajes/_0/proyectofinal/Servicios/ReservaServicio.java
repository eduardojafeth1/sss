package unah.lenguajes._0.proyectofinal.Servicios;

import java.math.BigDecimal;
import java.util.List;

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


    public String crear(ReservaDto booked){
        Reserva newReserva = new Reserva();
        float costo=0;
        if(!usuariosRepositorio.existsById(booked.getDni()) || !habitacionRepositorio.existsById(booked.getCdg_habitacion()) ){
            return "usurio o habitacion no existen";
        }
        try {
            newReserva.setCliente(usuariosRepositorio.findById(booked.getDni()).get());
            newReserva.setHabitacion(habitacionRepositorio.findById(booked.getCdg_habitacion()).get());
            // costo+=habitacionRepositorio.findById(booked.getCdg_habitacion()).get().getPrecio_noche()*(Integer.valueOf(Date. booked.getFecha_fin()-booked.getFecha_fin()));
            newReserva.setFecha_inicio(booked.getFecha_inicio());
            newReserva.setFecha_fin(booked.getFecha_fin());

            Servicio newServicio =new Servicio();

            Alimento newAlimento =new Alimento();
            newAlimento.setDesayuno(booked.isDesayuno());
            costo+=10;
            newAlimento.setAlmuerzo(booked.isAlmuerzo());
            costo+=10;
            newAlimento.setCena(booked.isCena());
            costo+=10;


            newServicio.setAlimento(newAlimento);

            Lavanderia newlLavanderia = new Lavanderia();
            newlLavanderia.setCant_prendas(booked.getCantidadPrendas());
            newlLavanderia.setCosto_prenda(3);
            newlLavanderia.setCosto_total(booked.getCantidadPrendas()*3);


            newServicio.setLavanderia(newlLavanderia);

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

         } catch (Exception e) {
             return "hubo un error";
         }
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

    public Reserva Buscarporid(Integer id){
        if(reservaRepositorio.existsById(id)){
            return reservaRepositorio.findById(id).get();
        }
        return null;

    }

    public List<Reserva> verReservas(){
        return reservaRepositorio.findAll();
    }




}
