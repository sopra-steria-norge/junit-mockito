package com.soprasteria.vedtak;


import com.soprasteria.beregning.UtbetalingBeregner;
import com.soprasteria.kunde.Kunde;
import com.soprasteria.kunde.KundeRepository;
import com.soprasteria.digitalpost.DigitalPostKlient;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class VedtakServiceTest {

    @Test
    public void sender_digital_post_naar_vedtak_godkjennes_captor() {
        DigitalPostKlient digitalPostKlient = mock(DigitalPostKlient.class);
        UtbetalingBeregner utbetalingBeregner = mock(UtbetalingBeregner.class);
        KundeRepository kundeRepository = mock(KundeRepository.class);

        VedtakService vedtakService = new VedtakService(digitalPostKlient, utbetalingBeregner, kundeRepository);

        Long kundeId = 5L;
        String navn = "Ola Normann";

        when(utbetalingBeregner.beregnUtbetalingFor(kundeId)).thenReturn(BigDecimal.TEN);
        when(kundeRepository.getKunde(kundeId)).thenReturn(new Kunde(navn));

        ArgumentCaptor<Vedtaksbrev> captor = ArgumentCaptor.forClass(Vedtaksbrev.class);

        vedtakService.godkjennVedtak(kundeId);

        verify(digitalPostKlient).sendVedtaksbrev(any(UUID.class),
                captor.capture());
        Vedtaksbrev captured = captor.getValue();

        assertThat(captured.getNavn()).isEqualTo(navn);
        assertThat(captured.getBelop()).isEqualTo(BigDecimal.TEN);
    }

}