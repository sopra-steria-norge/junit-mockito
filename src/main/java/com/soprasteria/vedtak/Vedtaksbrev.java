package com.soprasteria.vedtak;

import java.math.BigDecimal;

public class Vedtaksbrev {
    private final String navn;
    private final BigDecimal belop;
    private final String saksbehandler;


    public Vedtaksbrev(BigDecimal utbetaling, String navn, String saksbehandler) {
        this.belop = utbetaling;
        this.navn = navn;
        this.saksbehandler = saksbehandler;
    }

    public String getNavn() {
        return navn;
    }

    public BigDecimal getBelop() {
        return belop;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vedtaksbrev{");
        sb.append("navn='").append(navn).append('\'');
        sb.append(", belop=").append(belop);
        sb.append(", saksbehandler='").append(saksbehandler).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
