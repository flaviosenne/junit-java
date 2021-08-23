package com.tdd.junit.udemy;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @Mock
    List<String> lista;


    @Test
    void primeiroTesteMockito(){
        Mockito.when(lista.size()).thenReturn(20);

        int size = 0;

        if(1 == 1){
            size = lista.size();
        }

        BDDAssertions.assertThat(size).isEqualTo(20);
        Mockito.verify(lista, Mockito.times(1)).size();
    }

    @Test
    void segundoTesteMockito(){
        lista.size();
        lista.add("");

        InOrder inOrder = Mockito.inOrder(lista);
        inOrder.verify(lista).size();
        inOrder.verify(lista).add("");
    }
}
