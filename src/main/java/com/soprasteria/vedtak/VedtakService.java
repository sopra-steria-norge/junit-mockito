package com.soprasteria.vedtak;

import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.digitalpost.DigitalPostKlient;

import java.math.BigDecimal;

class VedtakService {
    private final DigitalPostKlient digitalPostKlient;
    private final UtbetalingBeregner utbetalingBeregner;

    VedtakService(DigitalPostKlient digitalPostKlient, UtbetalingBeregner utbetalingBeregner) {
        this.digitalPostKlient = digitalPostKlient;
        this.utbetalingBeregner = utbetalingBeregner;
    }

    String godkjennVedtak(Long kundeId) {
        BigDecimal utbetaling = utbetalingBeregner.beregnUtbetalingFor(kundeId);
        digitalPostKlient.sendVedtaksbrev(utbetaling);
        return digitalPostKlient.sendVedtaksbrev(utbetaling);
    }
}
