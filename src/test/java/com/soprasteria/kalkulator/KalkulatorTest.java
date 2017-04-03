package com.soprasteria.kalkulator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KalkulatorTest {

    @Test
    public void skal_få_4_når_1_og_3_adderes() {
        // Arrange
        Kalkulator kalkulator = new Kalkulator();

        // Act
        int resultat = kalkulator.adder(1, 3);

        // Assert
        assertThat(resultat).isEqualTo(4);
    }

    @Test
    public void skal_få_5_når_7_subtraheres_fra_12() {
        Kalkulator kalkulator = new Kalkulator();

        int resultat = kalkulator.subtraher(12, 7);

        assertThat(resultat).isEqualTo(5);
    }

    @Test
    public void skal_få_21_når_3_multipliseres_med_7() {
        Kalkulator kalkulator = new Kalkulator();

        int resultat = kalkulator.multipliser(3, 7);

        assertThat(resultat).isEqualTo(21);
    }

}
