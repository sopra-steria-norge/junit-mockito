package com.soprasteria.vedtak;

import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.com.soprasteria.kunde.Kunde;
import com.soprasteria.com.soprasteria.kunde.KundeRepository;
import com.soprasteria.digitalpost.DigitalPostKlient;

import java.math.BigDecimal;
import java.util.UUID;

class VedtakService {
    private final DigitalPostKlient digitalPostKlient;
    private final UtbetalingBeregner utbetalingBeregner;
    private final KundeRepository kundeRepository;

    VedtakService(DigitalPostKlient digitalPostKlient, UtbetalingBeregner utbetalingBeregner, KundeRepository kundeRepository) {
        this.digitalPostKlient = digitalPostKlient;
        this.utbetalingBeregner = utbetalingBeregner;
        this.kundeRepository = kundeRepository;
    }

    void godkjennVedtak(Long kundeId) {
        BigDecimal utbetaling = utbetalingBeregner.beregnUtbetalingFor(kundeId);
//        Kunde kunde = kundeRepository.getKunde(kundeId);
        if(positivVerdi(utbetaling)) {
            digitalPostKlient.sendVedtaksbrev(UUID.randomUUID(), utbetaling);
//            digitalPostKlient.sendVedtaksbrev(UUID.randomUUID(), new Vedtaksbrev(utbetaling, kunde.getNavn()));
        }
    }

    private boolean positivVerdi(BigDecimal utbetaling) {
        return utbetaling.compareTo(BigDecimal.ZERO) > 0;
    }
}
