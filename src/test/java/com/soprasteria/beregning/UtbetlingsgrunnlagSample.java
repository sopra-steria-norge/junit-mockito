package com.soprasteria.beregning;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;

public class UtbetlingsgrunnlagSample {
    private BigDecimal omberegningsfaktor = BigDecimal.valueOf(RandomUtils.nextDouble(0.5d, 15.0d));
    private BigDecimal grunnbeloep = BigDecimal.valueOf(RandomUtils.nextDouble(0d, 20000d));



    public Utbetalingsgrunnlag build() {
        return new Utbetalingsgrunnlag(omberegningsfaktor, grunnbeloep);
    }
}
