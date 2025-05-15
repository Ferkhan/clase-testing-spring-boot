package com.fkn.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCalculadora {
    // Buena práctica 
    // Inicializar o limpiar los objetos que vamos a utilizar en las pruebas

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora(); // creamos el objeto antes de cada prueba
    }

    // Un objeto para realizar las pruebas
    Calculadora calculadora = new Calculadora();

    @Test
    void testSumar() {
        // Prueba de la suma
        assertEquals(5, calculadora.sumar(2, 3));
    }

    @Test
    void testRestar() {
        // Prueba de la resta
        assertEquals(-1, calculadora.restar(2, 3));
    }

    @Test
    void testMultiplicar() {
        // Prueba de la multiplicación
        assertEquals(6, calculadora.multiplicar(2, 3));
    }

    @Test
    void testDividir() {
        // Prueba de la división
        assertEquals(2, calculadora.dividir(6, 3));
    }

    @Test
    void testDividirPorCero() {
        // Prueba de la división por cero

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.dividir(1, 0);
        });
        assertEquals("El divisor no puede ser cero", exception.getMessage());
    }

    // assertTrue(3>2);
    // assertFalse(3>2);
    // assertNull(3>2);
    // assertNotNull(3>2);

    @AfterEach
    void testDown() {
        // Limpiar el objeto después de cada prueba
        calculadora = null;
    }
}
