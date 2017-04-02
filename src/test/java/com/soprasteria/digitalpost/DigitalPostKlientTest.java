package com.soprasteria.digitalpost;

import com.soprasteria.vedtak.Vedtaksbrev;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.mock;

public class DigitalPostKlientTest {

    @Test
    public void sender_avansert_meldingsobjekt() {
        SDPKlient sdpKlient = mock(SDPKlient.class);
        String resultat = UUID.randomUUID().toString();
        Mockito.when(sdpKlient.sendMelding(Mockito.any(AvansertMeldingsobjekt.class))).thenReturn(resultat);

        Assertions.assertThat(new DigitalPostKlient(sdpKlient).sendVedtaksbrev(
                UUID.randomUUID(),
                new Vedtaksbrev(BigDecimal.ONE, "Ola", "Per"))).isEqualTo(resultat);
    }


}