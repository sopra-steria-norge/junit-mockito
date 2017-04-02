package com.soprasteria.eksempel;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockitoVerifyExample {
    @Test
    public void eksempel() {
        List<String> liste = mock(List.class);

        liste.add("En streng");

        verify(liste).add("En streng");
    }

}
