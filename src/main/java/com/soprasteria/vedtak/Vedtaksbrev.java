package com.soprasteria.vedtak;

import java.math.BigDecimal;
import java.util.Objects;

public class Vedtaksbrev {
    private final String epostadresse;
    private final BigDecimal belop;

    public Vedtaksbrev(BigDecimal belop, String epostadresse) {
        this.belop = belop;
        this.epostadresse = epostadresse;
    }

    public String getEpostadresse() {
        return epostadresse;
    }

    public BigDecimal getBelop() {
        return belop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vedtaksbrev that = (Vedtaksbrev) o;
        return Objects.equals(epostadresse, that.epostadresse) &&
                Objects.equals(belop, that.belop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(epostadresse, belop);
    }
}
