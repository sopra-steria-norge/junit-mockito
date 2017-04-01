package com.soprasteria.beregning;

import java.math.BigDecimal;

public class UtbetalingBeregner {
    private final UtbetalingsgrunnlagRepository utbetalingsgrunnlagRepository;

    UtbetalingBeregner(UtbetalingsgrunnlagRepository utbetalingsgrunnlagRepository) {
        this.utbetalingsgrunnlagRepository = utbetalingsgrunnlagRepository;
    }

    public BigDecimal beregnUtbetalingFor(String kundeId) {
        Utbetalingsgrunnlag utbetalingsgrunnlag = utbetalingsgrunnlagRepository.findUtbetalingsgrunnlag(kundeId);
        return BigDecimal.ZERO;
    }
}
