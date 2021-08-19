package com.curso.junit;

import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTeste {

    @Test
    public void estruturaDeUmTeste(){
        // cenario
        int numero1 =10, numero2 =5;

        // execução
        int resultado = numero1 + numero2;

        // verificação
        Assert.assertEquals(15, resultado);
    }
}
