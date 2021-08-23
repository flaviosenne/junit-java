package com.tdd.junit.udemy.primeiro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrimeiroTest {

    Calculadora calc;
    int num1, num2;

    @BeforeEach
    public void setup(){
        calc = new Calculadora();

        num1 = 10;
        num2 =5;
    }
    @Test
    public void deveSomarDoisNumeros() {

        // execução
        int result = calc.somar(this.num1, this.num2);

        Assertions.assertThat(result).isEqualTo(15);
        Assertions.assertThat(result).isPositive();
        Assertions.assertThat(result).isGreaterThanOrEqualTo(15);
        Assertions.assertThat(result).isGreaterThan(10);
        Assertions.assertThat(result).isBetween(14, 16);
    }

    @Test
    void deveSubtrairDoisNumeros(){
       // execução
        int result = calc.subtrair(this.num1, this.num2);

        //verificação
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void deveMultiplicarDoisNumeros(){
        // execução
        int result = calc.multiplicar(this.num1, this.num2);

        //verificação
        Assertions.assertThat(result).isEqualTo(50);
    }

    @Test
    void deveDividirDoisNumeros(){
        // execução
        float result = calc.dividir(this.num1, this.num2);

        //verificação
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void naoDeveSomarNumerosNegativos(){

        // execução
        Assertions.assertThatThrownBy(()-> calc.somar(num1, -num2));

    }

    @Test
    public void naoDeveSDividirPorZero(){

        // execução
        Assertions.assertThatThrownBy(()-> calc.dividir(num1, 0));

    }
}
class Calculadora {
    int somar(int num1, int num2){
        if(num1 < 0 || num2 < 0){
            throw  new RuntimeException("Não é possivel somar numeros negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1, int num2){
        return num1 - num2;
    }

    int multiplicar(int num1, int num2){
        return num1 * num2;
    }
    float dividir(int num1, int num2){
        if(num1 <= 0 || num2 <= 0){
            throw  new RuntimeException("Não é possivel dividir numeros negativos ou zero");
        }
        return num1 / num2;
    }

}

