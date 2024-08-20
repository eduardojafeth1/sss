package unah.lenguajes._0.proyectofinal.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes._0.proyectofinal.DTOs.ResponseLogin;
import unah.lenguajes._0.proyectofinal.Modelos.Usuarios;
import unah.lenguajes._0.proyectofinal.Servicios.UsuariosServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControlador {

    @Autowired
    private UsuariosServicio usuariosServicio;
    
    @GetMapping("/verTodos")
    public List<Usuarios> ver() {
        return usuariosServicio.verUsuarios();
    }
    
    @GetMapping("/ver/{dni}")
    public Usuarios ver(@PathVariable String dni) {
        return usuariosServicio.usuariospordni(dni);
    }

    

    @PostMapping("/crear")
    public String crear(@RequestBody Usuarios usuario) {
    return usuariosServicio.crearUsuario(usuario);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrar(@PathVariable String id) {
       return usuariosServicio.borrarUsuario(id);
    }

    @PutMapping("/editar/{dni}")
    public String editar(@RequestBody Usuarios usuario,@PathVariable String dni) {
        return usuariosServicio.EditarUsuario(usuario, dni);
    }

    @GetMapping("Login")
    public ResponseLogin login(@RequestParam String email, @RequestParam String contraseña) {
    return usuariosServicio.Login(email, contraseña);
    }
}
