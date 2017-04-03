package com.soprasteria.filleser;

import com.soprasteria.fil.FilLeser;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FilLeserTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void skal_lese_første_linje_fra_fil() throws Exception {
        File tempFile = temporaryFolder.newFile();
        Files.write(tempFile.toPath(), Arrays.asList("Lisa gikk til skolen"));

        String linje = FilLeser.lesLinjeFraFil(tempFile.getPath(), 0);

        assertThat(linje).isEqualTo("Lisa gikk til skolen");
    }

    @Test
    public void skal_lese_andre_linje_fra_fil() throws Exception {
        File tempFile = temporaryFolder.newFile();
        Files.write(tempFile.toPath(), Arrays.asList("Lisa gikk til skolen", "Tripp, tripp, tripp det sa"));

        String linje2 = FilLeser.lesLinjeFraFil(tempFile.getPath(), 1);

        assertThat(linje2).isEqualTo("Tripp, tripp, tripp det sa");
    }
}
