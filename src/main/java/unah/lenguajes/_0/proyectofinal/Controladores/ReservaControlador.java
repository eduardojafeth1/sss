package unah.lenguajes._0.proyectofinal.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes._0.proyectofinal.DTOs.LoginDto;
import unah.lenguajes._0.proyectofinal.DTOs.ReservaDto;
import unah.lenguajes._0.proyectofinal.Modelos.Reserva;
import unah.lenguajes._0.proyectofinal.Servicios.ReservaServicio;

@RestController
@RequestMapping("/reserva")
public class ReservaControlador {
    
    @Autowired
    private ReservaServicio reservaServicio;

    @PostMapping("/crear")
    public String crearReserva(@RequestBody ReservaDto reserva){
        return reservaServicio.crearReserva(reserva);
    }
}
