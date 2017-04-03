package com.soprasteria.kalkulator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class KalkulatorMultipliserTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {0, 0, 0},
            {1, 0, 0},
            {2, 1, 2},
            {3, 2, 6},
            {4, 3, 12},
            {5, 5, 25},
            {6, 8, 48}
        });
    }

    @Parameter
    public int multiplikand;

    @Parameter(1)
    public int multiplikator;

    @Parameter(2)
    public int produkt;

    @Test
    public void skal_få_produkt_når_multiplikand_multipliseres_med_multiplikator() {
        Kalkulator kalkulator = new Kalkulator();

        int resultat = kalkulator.multipliser(multiplikand, multiplikator);

        assertThat(resultat).isEqualTo(produkt);
    }
}
