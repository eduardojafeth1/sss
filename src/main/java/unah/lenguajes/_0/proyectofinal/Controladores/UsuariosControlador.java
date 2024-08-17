package unah.lenguajes._0.proyectofinal.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes._0.proyectofinal.Modelos.Usuarios;
import unah.lenguajes._0.proyectofinal.Servicios.UsuariosServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControlador {

    @Autowired
    private UsuariosServicio usuariosServicio;
    
    @GetMapping("/ver")
    public List<Usuarios> ver() {
        return usuariosServicio.verUsuarios();
    }

    @PostMapping("/crear")
    public String crear(@RequestBody Usuarios usuario) {
    return usuariosServicio.crearUsuario(usuario);
    }
}
