package com.soprasteria.vedtak;


import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.digitalpost.DigitalPostKlient;
import com.soprasteria.kunde.Kunde;
import com.soprasteria.kunde.KundeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VedtakServiceTest {
    private DigitalPostKlient digitalPostKlient = mock(DigitalPostKlient.class);
    private UtbetalingBeregner utbetalingBeregner = mock(UtbetalingBeregner.class);
    private KundeRepository kundeRepository = mock(KundeRepository.class);

    private Long kundeId = 5L;
    private String navn = "Ola Normann";
    private String saksbehandler = "saksbehandler";

    @Before
    public void setup() {
        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenReturn(BigDecimal.TEN);
        when(kundeRepository.getKunde(kundeId)).thenReturn(new Kunde(navn));
    }

    @Test
    public void sender_digital_post_naar_vedtak_godkjennes_spy() {
        VedtakService vedtakService = spy(new VedtakService(digitalPostKlient, utbetalingBeregner, kundeRepository));

        when(vedtakService.getCurrentUser()).thenReturn(saksbehandler);

        ArgumentCaptor<Vedtaksbrev> captor = ArgumentCaptor.forClass(Vedtaksbrev.class);

        vedtakService.godkjennVedtak(kundeId);

        verify(digitalPostKlient).sendVedtaksbrev(any(UUID.class),
                captor.capture());
        Vedtaksbrev captured = captor.getValue();

        assertThat(captured.getNavn()).isEqualTo(navn);
        assertThat(captured.getSaksbehandler()).isEqualTo(saksbehandler);
        assertThat(captured.getBelop()).isEqualTo(BigDecimal.TEN);
    }

    @Test
    public void sender_digital_post_naar_vedtak_godkjennes_override() {
        VedtakService vedtakService = new VedtakService(digitalPostKlient, utbetalingBeregner, kundeRepository){
            String getCurrentUser() {
                return saksbehandler;
            }
        };

        ArgumentCaptor<Vedtaksbrev> captor = ArgumentCaptor.forClass(Vedtaksbrev.class);

        vedtakService.godkjennVedtak(kundeId);

        verify(digitalPostKlient).sendVedtaksbrev(any(UUID.class),
                captor.capture());
        Vedtaksbrev captured = captor.getValue();

        assertThat(captured.getNavn()).isEqualTo(navn);
        assertThat(captured.getSaksbehandler()).isEqualTo(saksbehandler);
        assertThat(captured.getBelop()).isEqualTo(BigDecimal.TEN);
    }

}