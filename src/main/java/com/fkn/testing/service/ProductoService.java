package com.fkn.testing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fkn.testing.model.Producto;
import com.fkn.testing.respository.ProductoRespository;

@Service
public class ProductoService {
    // Aquí puedes agregar métodos para interactuar con la base de datos
    // utilizando el repositorio de productos (ProductoRespository)
    
    @Autowired
    private ProductoRespository productoRespository;
    
    // MÉTODOS
    
    public List<Producto> obtenerTodos() {
        return productoRespository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRespository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRespository.save(producto);
    }

    public void eliminar(Long id) {
        productoRespository.deleteById(id);
    }
}
