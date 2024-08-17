package unah.lenguajes._0.proyectofinal.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes._0.proyectofinal.Modelos.Usuarios;
import unah.lenguajes._0.proyectofinal.Repositorios.UsuariosRepositorio;

@Service
public class UsuariosServicio {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    public List<Usuarios> verUsuarios(){
        return usuariosRepositorio.findAll();
    }

    public String crearUsuario(Usuarios usuario){
        if(!usuariosRepositorio.existsById(usuario.getDni())){
            Usuarios newuser= new Usuarios();
            newuser=usuario;
            usuariosRepositorio.save(newuser);
            return ("usuario creado correctamente");
           
        }
        return "usuario ya existe";

    }
}
