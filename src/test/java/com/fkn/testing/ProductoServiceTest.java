package com.fkn.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fkn.testing.model.Producto;
import com.fkn.testing.respository.ProductoRespository;
import com.fkn.testing.service.ProductoService;

public class ProductoServiceTest {

    @Mock
    private ProductoRespository productoRespository;

    @InjectMocks
    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerTodos() {
        when(productoRespository.findAll()).thenReturn(
            // List.of(
            //     new Producto(1L, "Producto 1", 10.0),
            //     new Producto(2L, "Producto 2", 20.0)
            // )
            Arrays.asList(
                new Producto(1L, "Producto 1", 10.0),
                new Producto(2L, "Producto 2", 20.0)
            )
        );
        
        List<Producto> productos = productoService.obtenerTodos();

        assertEquals(2, productos.size());
    }

    @Test
    void testObtenerPorId() {
        Producto producto = new Producto(1L, "Teclado", 10.0);
        when(productoRespository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> productoObtenido = productoService.obtenerPorId(1L);

        assertTrue(productoObtenido.isPresent());
        assertEquals("Teclado", productoObtenido.get().getNombre());
        verify(productoRespository).findById(1L);    
    }

    @Test
    void testGuardar() {
        Producto producto = new Producto(null, "Monitor", 10.0);
        Producto productoGuardado = new Producto(3L, "Monitor", 10.0);
        when(productoRespository.save(producto)).thenReturn(productoGuardado);

        Producto productoResultado = productoService.guardar(producto);
        assertNotNull(productoResultado.getId());
        assertEquals(3L, productoResultado.getId());
        verify(productoRespository).save(producto);
    }

    @Test
    void testEliminar() {
        Long id = 1L;
        doNothing().when(productoRespository).deleteById(id);
        productoService.eliminar(id);
        verify(productoRespository).deleteById(id);
    }
}
