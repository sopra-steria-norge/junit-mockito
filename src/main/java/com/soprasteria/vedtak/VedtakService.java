package com.soprasteria.vedtak;

import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.digitalpost.DigitalPostKlient;

import java.math.BigDecimal;

class VedtakService {
    private DigitalPostKlient digitalPostKlient;
    private UtbetalingBeregner utbetalingBeregner;


    public void godkjennVedtak(Long kundeId) {
        BigDecimal utbetaling = utbetalingBeregner.beregnUtbetalingFor(kundeId);
        digitalPostKlient.sendVedtaksbrev(utbetaling);
    }
}
