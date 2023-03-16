package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatReturnTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
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
    public void getKittensOneCount() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensThreeCount() {
        feline.getKittens(3);
        assertEquals(3, feline.getKittens(3));
    }
}