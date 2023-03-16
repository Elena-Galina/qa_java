package com.example;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensDefaultCount() {
        Lion lion = new Lion(feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodReturnEatMeatTest() throws Exception {
        Lion lion = new Lion(feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test (expected = Exception.class)
    public void LionHasManeExceptionTest() throws Exception {
        Lion lion = new Lion("Неизвестно");
        boolean result =  lion.hasMane;
        System.out.println(result);
    }

    @Test
    public void LionMessageExceptionTest(){
        Exception exception = Assert.assertThrows("Проверка", Exception.class, () -> new Lion("Нет пола"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}