package com.example.demo.Controllers;
import com.example.demo.Model.UsuarioModel;
import com.example.demo.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){

        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return  this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorID(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId (@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id " + id;
        }else {
            return "No se pudo eliminar el usuario con id" + id;
        }
    }


}
