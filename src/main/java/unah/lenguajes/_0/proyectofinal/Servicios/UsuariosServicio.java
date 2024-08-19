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


    public Usuarios usuariospordni(String dni){
        return usuariosRepositorio.findById(dni).get();
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

    public String borrarUsuario(String user){
        if(usuariosRepositorio.existsById(user)){
            usuariosRepositorio.deleteById(user);
            return "usuario borrado con exito";
        }
        return "usuario no existe";
    }

    public String EditarUsuario(Usuarios user,String dni){
        if(usuariosRepositorio.existsById(dni)){
            Usuarios usuarioactualizar =usuariosRepositorio.findById(dni).get();
            if(user.getApellido() != null && !user.getApellido().isEmpty()){
                usuarioactualizar.setApellido(user.getApellido());
            }
            if(user.getContrasena() != null && !user.getContrasena().isEmpty()){
                usuarioactualizar.setContrasena(user.getContrasena());
            }
            if(user.getEmail() != null && !user.getEmail().isEmpty()){
                usuarioactualizar.setEmail(user.getEmail());
            }
            if(user.getNombre() != null && !user.getNombre().isEmpty()){
                usuarioactualizar.setNombre(user.getNombre());
            }
            if(user.getTelefono() != null && !user.getTelefono().isEmpty()){
                usuarioactualizar.setTelefono(user.getTelefono());
            }
        usuariosRepositorio.save(usuarioactualizar);
        return "usuario editado con exito";
        }
        return "Usuario no existe";
    }


    public String Login(String email,String password){
        try {
            return usuariosRepositorio.findUsuariosByEmailAndContrasena(email, password).get().getDni();
            
        } catch (Exception e) {
            return "email o contrasena incorrecta";
        }
    }
}
