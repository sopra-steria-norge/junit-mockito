package com.soprasteria.kalkulator;

import org.junit.Assert;
import org.junit.Test;

public class KalkulatorTest {

    @Test
    public void skal_få_4_når_1_og_3_adderes() {
        // Arrange
        Kalkulator kalkulator = new Kalkulator();

        // Act
        int resultat = kalkulator.adder(1, 3);

        // Assert
        Assert.assertEquals(4, resultat);
    }

    @Test
    public void skal_få_5_når_7_subtraheres_fra_12() {
        Kalkulator kalkulator = new Kalkulator();

        int resultat = kalkulator.subtraher(12, 7);

        Assert.assertEquals(5, resultat);
    }

    @Test
    public void skal_få_21_når_3_multipliseres_med_7() {
        Kalkulator kalkulator = new Kalkulator();

        int resultat = kalkulator.multipliser(3, 7);

        Assert.assertEquals(21, resultat);
    }

}
