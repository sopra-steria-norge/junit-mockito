package com.soprasteria.beregning;

import java.math.BigDecimal;

public class UtbetalingBeregner {
    private final UtbetalingsgrunnlagRepository utbetalingsgrunnlagRepository;

    UtbetalingBeregner(UtbetalingsgrunnlagRepository utbetalingsgrunnlagRepository) {
        this.utbetalingsgrunnlagRepository = utbetalingsgrunnlagRepository;
    }

    public BigDecimal beregnUtbetalingFor(Long kundeId) {
        Utbetalingsgrunnlag utbetalingsgrunnlag = utbetalingsgrunnlagRepository.findUtbetalingsgrunnlag(kundeId);
        return utbetalingsgrunnlag.getGrunnbeloep().multiply(utbetalingsgrunnlag.getOmberegningsFaktor());
    }
}
