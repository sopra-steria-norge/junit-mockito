package com.soprasteria.filbehandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilLeser {

    public static String lesLinjeFraFil(String filePath, int lineNumber) throws IOException {
        return Files.readAllLines(Paths.get(filePath)).get(lineNumber);
    }
}
