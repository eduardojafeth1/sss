package unah.lenguajes._0.proyectofinal.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import unah.lenguajes._0.proyectofinal.DTOs.ReservaDto;
import unah.lenguajes._0.proyectofinal.Modelos.Reserva;
import unah.lenguajes._0.proyectofinal.Servicios.ReservaServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/reserva")
public class ReservaControlador {
    
    @Autowired
    private ReservaServicio reservaServicio;

    @PostMapping("/crear")
    public String crearReserva(@RequestBody ReservaDto reserva){
        return reservaServicio.crear(reserva);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarReserva(@PathVariable Integer id){
        return reservaServicio.borrarReserva(id);
    }


    @GetMapping("/vertodos/{id}")
    public Reserva getMethodName(@PathVariable Integer id) {
        return reservaServicio.Buscarporid(id);
    }

    @GetMapping("/vertodo")
    public List<Reserva> obtenertodo() {
        return reservaServicio.verReservas();
    }
    
    
}
