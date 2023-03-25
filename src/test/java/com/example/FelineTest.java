package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatReturnTest() throws Exception {
        feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
    }

    @Test
    public void getFamilyReturnTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensDefaultCount() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensThreeCount() {
        assertEquals(3, feline.getKittens(3));
    }
}