package com.example.demo.Repositories;

import com.example.demo.Model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);

    // TODO: 17/02/22 Primera mejora: Con este se puede buscar por nombre.

    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);


}
