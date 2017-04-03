package com.soprasteria.filleser;

import com.soprasteria.fil.FilLeser;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FilLeserTest {

    private File tempFile;

    @Before
    public void setUp() throws IOException {
        tempFile = new File("tempfile.txt");
        Files.write(tempFile.toPath(), Arrays.asList("Lisa gikk til skolen", "Tripp, tripp, tripp det sa"));
    }

    @Ignore("Ignorert fordi ... ")
    @Test
    public void skal_lese_første_linje_fra_fil() throws Exception {
        String linje = FilLeser.lesLinjeFraFil(tempFile.getPath(), 0);

        assertThat(linje).isEqualTo("Lisa gikk til skolen");
    }

    @Test
    public void skal_lese_andre_linje_fra_fil() throws Exception {
        String linje2 = FilLeser.lesLinjeFraFil(tempFile.getPath(), 1);

        assertThat(linje2).isEqualTo("Tripp, tripp, tripp det sa");
    }

    @After
    public void tearDown() {
        tempFile.delete();
    }
}
