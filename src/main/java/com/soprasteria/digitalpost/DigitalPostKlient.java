package com.soprasteria.digitalpost;

import com.soprasteria.vedtak.Vedtaksbrev;

import java.util.UUID;

public class DigitalPostKlient {
    private final SDPKlient sdpKlient;

    public DigitalPostKlient(SDPKlient sdpKlient) {
        this.sdpKlient = sdpKlient;
    }
    public String sendVedtaksbrev(UUID uuid, Vedtaksbrev vedtaksbrev) {
        return sdpKlient.sendMelding(new AvansertMeldingsobjekt(uuid, vedtaksbrev));
    }
}
