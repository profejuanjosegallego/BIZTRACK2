package com.example.BIZTRACK2.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.BIZTRACK2.models.Usuario;
import com.example.BIZTRACK2.repository.IRepositorioUsuario;

@Service 
public class ServicioUsuario {

    @Autowired 
    IRepositorioUsuario repositorioUsuario;


    public Usuario guardar(Usuario datosUsuario){

        return this.repositorioUsuario.save(datosUsuario);

    }

    public List<Usuario> buscar(){
        return this.repositorioUsuario.findAll();

    }

    public Usuario modificar(UUID id, Usuario datosNuevos){

        Optional<Usuario> usuarioBuscado=this.repositorioUsuario.findById(id);
        if(usuarioBuscado.isPresent()){
            //hay a quien actualizar
            Usuario usuarioEncontrado=usuarioBuscado.get();

            //Modificando los datos
            usuarioEncontrado.setNombre(datosNuevos.getNombre());
            usuarioEncontrado.setCorreo(datosNuevos.getCorreo());

            //Guardo los cambios
            return this.repositorioUsuario.save(usuarioEncontrado);

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado");
        }

    }


}
