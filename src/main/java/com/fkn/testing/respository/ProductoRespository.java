package com.fkn.testing.respository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fkn.testing.model.Producto;

public interface ProductoRespository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar métodos personalizados para interactuar con la base de datos
    // por ejemplo, buscar productos por nombre, precio, etc.
    
    // Ejemplo de método personalizado
    // List<Producto> findByNombre(String nombre);

}
