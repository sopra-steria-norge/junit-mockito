package com.soprasteria.beregning;

import java.math.BigDecimal;

class Utbetalingsgrunnlag {
    private BigDecimal omberegningsFaktor;
    private BigDecimal grunnbeloep;

    Utbetalingsgrunnlag(BigDecimal omberegningsFaktor, BigDecimal grunnbeloep){
        this.omberegningsFaktor = omberegningsFaktor;
        this.grunnbeloep = grunnbeloep;
    }

    public BigDecimal getOmberegningsFaktor() {
        return omberegningsFaktor;
    }

    public BigDecimal getGrunnbeloep() {
        return grunnbeloep;
    }
}
