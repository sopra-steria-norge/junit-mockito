package com.soprasteria.vedtak;

import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.digitalpost.DigitalPostKlient;

import java.math.BigDecimal;
import java.util.UUID;

class VedtakService {
    private final DigitalPostKlient digitalPostKlient;
    private final UtbetalingBeregner utbetalingBeregner;

    VedtakService(DigitalPostKlient digitalPostKlient, UtbetalingBeregner utbetalingBeregner) {
        this.digitalPostKlient = digitalPostKlient;
        this.utbetalingBeregner = utbetalingBeregner;
    }

    void godkjennVedtak(Long kundeId) {
        BigDecimal utbetaling = utbetalingBeregner.beregnUtbetalingFor(kundeId);
//        UUID uuid = UUID.randomUUID();
        digitalPostKlient.sendVedtaksbrev(utbetaling);
    }
}
