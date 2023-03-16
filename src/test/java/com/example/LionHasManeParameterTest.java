package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionHasManeParameterTest {
    public final String sex;
    public final boolean expected;

    public LionHasManeParameterTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Проверка наличия гривы. Пол животного: {0} Результат: {1}")
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void LionHasManeTest() throws Exception {
        Lion lion = new Lion(sex);
        Assert.assertEquals(expected, lion.hasMane);
    }

    @Test
    public void doesHaveManeReturnHasManeTest() throws Exception {
        Lion lion = new Lion(sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

}

