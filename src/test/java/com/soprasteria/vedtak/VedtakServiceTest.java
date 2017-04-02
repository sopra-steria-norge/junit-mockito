package com.soprasteria.vedtak;


import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.digitalpost.DigitalPostKlient;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class VedtakServiceTest {

    @Test
    public void sender_digital_post_naar_vedtak_godkjennes() {
        DigitalPostKlient digitalPostKlient = mock(DigitalPostKlient.class);
        UtbetalingBeregner utbetalingBeregner = mock(UtbetalingBeregner.class);
        VedtakService vedtakService = new VedtakService(digitalPostKlient, utbetalingBeregner);

        Long kundeId = 5L;
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenReturn(BigDecimal.TEN);
        when(digitalPostKlient.sendVedtaksbrev(BigDecimal.TEN)).thenReturn("referanse");

        Assertions.assertThat(vedtakService.godkjennVedtak(kundeId)).isEqualTo("referanse");
    }

}