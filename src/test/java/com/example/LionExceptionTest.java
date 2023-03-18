package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionExceptionTest {

    @Mock
    private Feline feline;

    @Test (expected = Exception.class)
    public void LionHasManeExceptionTest() throws Exception {
        Lion lion = new Lion("Неизвестно",feline);
        boolean result =  lion.hasMane;
        System.out.println(result);
    }

    @Test
    public void LionMessageExceptionTest(){
        Exception exception = Assert.assertThrows("Проверка", Exception.class, () -> new Lion("Нет пола",feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}