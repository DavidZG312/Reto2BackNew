/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.services;

import com.Reto2.Reto2.models.Productos;
import com.Reto2.Reto2.repositories.ProductosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class ProductosService {
    
    @Autowired
    private ProductosRepository productoRepository;

    public List<Productos> getAll() {
        return productoRepository.getAll();
    }

    public Productos getById(String reference) {
        return productoRepository.getById(reference).orElse(null);
    }

    public Productos update(Productos productos) {
        if (productos.getReference() == null) 
            return productos;
        

        Optional<Productos> existeUsuario = productoRepository.getById(productos.getReference());

        if (existeUsuario.isEmpty()) 
            return productos;
        

        return productoRepository.save(productos);
    }

    public Productos save(Productos users) {

        if (users.getReference()== null) 
            return users;


        Optional<Productos> existeUsuario = productoRepository.getById(users.getReference());

        if (existeUsuario.isPresent()) 
            return users;
        

        return productoRepository.save(users);
    }

    public void delete(String id) {
        productoRepository.delete(id);
    }
}
