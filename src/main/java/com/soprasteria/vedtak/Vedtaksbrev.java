package com.soprasteria.vedtak;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vedtaksbrev that = (Vedtaksbrev) o;
        return Objects.equals(navn, that.navn) &&
                Objects.equals(belop, that.belop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(navn, belop);
    }
}
