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
