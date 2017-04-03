package com.soprasteria.kalkulator;

public class Kalkulator {

    public int adder(int ledd1, int ledd2) {
        return ledd1 + ledd2;
    }

    public int subtraher(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public int multipliser(int multiplikand, int multiplikator) {
        return multiplikand * multiplikator;
    }

    public int divider(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor kan ikke være 0!");
        }
        return dividend / divisor;
    }
}
