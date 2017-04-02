package com.soprasteria;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class IntroJukselapp {

    @Test
    public void mockito_when() {
        List<String> liste = Mockito.mock(List.class);
        Mockito.when(liste.get(0)).thenReturn("test");

        System.out.println(liste.get(0));
        System.out.println(liste.get(1));
    }

    @Test
    public void mockito_argumentmatcher() {
        List<String> liste = Mockito.mock(List.class);
        Mockito.when(liste.get(Mockito.anyInt())).thenReturn("test");

        System.out.println(liste.get(0));
        System.out.println(liste.get(1));
        System.out.println(liste.get(1000));
    }

    @Test
    public void mockito_verify() {
        List<String> liste = Mockito.mock(List.class);
        liste.add("hei");
        liste.add("hei");
//        System.out.println(liste.get(0));

        Mockito.verify(liste, Mockito.times(2)).add("hei");
        Mockito.verifyNoMoreInteractions(liste);
    }

    @Test
    public void mockito_spy() {
        List<String> liste = Mockito.spy(new ArrayList<String>());
        liste.add("hei");
        liste.add("hei2");
        System.out.println(liste.get(0));
        System.out.println(liste.get(1));
        Mockito.when(liste.get(0)).thenReturn("overstyrt");
        System.out.println(liste.get(0));
        System.out.println(liste.get(1));
    }

    @Test
    public void mockito_doThrow() {
        List<String> liste = Mockito.mock(List.class);
        Mockito.when(liste.get(0)).thenThrow(new IllegalStateException("test"));
//        liste.get(0);
        liste.clear();
        Mockito.doThrow(new IllegalStateException("test2")).when(liste).clear();
        liste.clear();
    }
}
