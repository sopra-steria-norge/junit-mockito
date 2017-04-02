package com.soprasteria.vedtak;

import java.math.BigDecimal;

public class Vedtaksbrev {
    private final String navn;
    private final BigDecimal belop;

    public Vedtaksbrev(BigDecimal belop, String navn) {
        this.belop = belop;
        this.navn = navn;
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
        sb.append('}');
        return sb.toString();
    }
}
