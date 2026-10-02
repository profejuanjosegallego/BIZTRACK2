package com.example.BIZTRACK2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BIZTRACK2.models.Usuario;
import com.example.BIZTRACK2.repository.IRepositorioUsuario;

@Service 
public class ServicioUsuario {

    @Autowired 
    IRepositorioUsuario repositorioUsuario;


    public Usuario guardar(Usuario datosUsuario){

        return this.repositorioUsuario.save(datosUsuario);

    }


}
