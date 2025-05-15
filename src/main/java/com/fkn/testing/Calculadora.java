package com.fkn.testing;

public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        if (b == 0) {
            // throw new ArithmeticException("No se puede dividir por cero");
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return a / b;
    }
}
