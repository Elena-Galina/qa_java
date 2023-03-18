package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterTest {
    private final String sex;
    private final boolean expected;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Feline feline;

    public LionParameterTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Пол животного: {0} Результат: {1}")
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void LionHasManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expected, lion.hasMane);
    }

    @Test
    public void doesHaveManeReturnHasManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensDefaultCount() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodReturnEatMeatTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}

