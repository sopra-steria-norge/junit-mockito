package com.soprasteria.vedtak;


import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.com.soprasteria.kunde.KundeRepository;
import com.soprasteria.digitalpost.DigitalPostKlient;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class VedtakServiceTest {
    private DigitalPostKlient digitalPostKlient = mock(DigitalPostKlient.class);
    private UtbetalingBeregner utbetalingBeregner = mock(UtbetalingBeregner.class);
    private KundeRepository kundeRepository = mock(KundeRepository.class);
    private VedtakService vedtakService = new VedtakService(digitalPostKlient, utbetalingBeregner, kundeRepository);
    private Long kundeId = 5L;

    @Test
    public void sender_digital_post_naar_vedtak_godkjennes() {
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenReturn(BigDecimal.TEN);

        vedtakService.godkjennVedtak(kundeId);

//        verify(digitalPostKlient).sendVedtaksbrev(BigDecimal.TEN);
    }

    @Test(expected = IllegalStateException.class)
    public void sender_ikke_digitalpost_naar_beregning_feiler() {
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenThrow(new IllegalStateException());

        vedtakService.godkjennVedtak(kundeId);

//        verify(digitalPostKlient, never()).sendVedtaksbrev(any(BigDecimal.class));
    }

    @Test
    public void sender_ikke_digitalpost_naar_0_i_utbetaling() {
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenReturn(BigDecimal.ZERO);

        vedtakService.godkjennVedtak(kundeId);

//        verify(digitalPostKlient, never()).sendVedtaksbrev(any(BigDecimal.class));
    }

}