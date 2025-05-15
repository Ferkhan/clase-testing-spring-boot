package com.fkn.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPersona {

    @Test
    void testObtenerDescripcion() {
        // Crear una instancia de Persona
        Persona persona = new Persona("Juan", 30);
        
        // Verificar que el método obtenerDescripcion devuelve la descripción correcta
        String descripcionEsperada = "Nombre: Juan, Edad: 30";
        String descripcionObtenida = persona.obtenerDescripcion();
        
        assertEquals(descripcionEsperada, descripcionObtenida);
    }

    @Test
    void testGetters() {
        // Crear una instancia de Persona
        Persona persona = new Persona("Juan", 30);
                                                                                                                                     
        // Verificar que los getters devuelven los valores correctos
        assertEquals("Juan", persona.getNombre());
        assertEquals(30, persona.getEdad());
    }
}
