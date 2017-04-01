package com.soprasteria.beregning;


import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UtbetalingBeregnerTest {

    @Test
    public void skal_multiplisere_omregningsfaktor_med_grunnbelop() {
        Long kundeId = 1L;
        Utbetalingsgrunnlag utbetalingsgrunnlag = new UtbetlingsgrunnlagSample().build();
        UtbetalingsgrunnlagRepository repository = mock(UtbetalingsgrunnlagRepository.class);
        when(repository.findUtbetalingsgrunnlag(kundeId)).thenReturn(utbetalingsgrunnlag);

        BigDecimal forventetResultat = utbetalingsgrunnlag.getGrunnbeloep().multiply(utbetalingsgrunnlag.getOmberegningsFaktor());
        assertThat(new UtbetalingBeregner(repository).beregnUtbetalingFor(kundeId)).isEqualTo(forventetResultat);
    }
}