package com.example.demo.Services;

import com.example.demo.Model.UsuarioModel;
import com.example.demo.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    //Matodo para ver todos los usuarios
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    //Metodo para asignarle un id al usuario
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorID (long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
