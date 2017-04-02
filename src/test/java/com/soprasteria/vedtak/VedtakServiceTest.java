package com.soprasteria.vedtak;


import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.com.soprasteria.kunde.Kunde;
import com.soprasteria.com.soprasteria.kunde.KundeRepository;
import com.soprasteria.digitalpost.DigitalPostKlient;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VedtakServiceTest {

    private DigitalPostKlient digitalPostKlient = mock(DigitalPostKlient.class);
    private UtbetalingBeregner utbetalingBeregner = mock(UtbetalingBeregner.class);
    private KundeRepository kundeRepository = mock(KundeRepository.class);
    private VedtakService vedtakService = new VedtakService(digitalPostKlient, utbetalingBeregner, kundeRepository);
    private Long kundeId = 5L;


    @Test
    public void sender_digital_post_naar_vedtak_godkjennes() {
        String navn = "Ola Normann";
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenReturn(BigDecimal.TEN);
        when(kundeRepository.getKunde(kundeId)).thenReturn(new Kunde(navn));
        vedtakService.godkjennVedtak(kundeId);

        Vedtaksbrev expected = new Vedtaksbrev(BigDecimal.TEN, navn);

        verify(digitalPostKlient).sendVedtaksbrev(any(UUID.class),
                Mockito.argThat(vedtaksbrev -> Objects.equals(expected.getNavn(), vedtaksbrev.getNavn())));
    }

    @Test(expected = IllegalStateException.class)
    public void sender_ikke_digitalpost_naar_beregning_feiler() {
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenThrow(new IllegalStateException());

        vedtakService.godkjennVedtak(kundeId);
        Mockito.verifyZeroInteractions(digitalPostKlient);
    }

    @Test
    public void sender_ikke_digitalpost_naar_0_i_utbetaling() {
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenReturn(BigDecimal.ZERO);

        vedtakService.godkjennVedtak(kundeId);
        Mockito.verifyZeroInteractions(digitalPostKlient);
    }

}