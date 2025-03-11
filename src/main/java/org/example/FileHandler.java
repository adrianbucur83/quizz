package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHandler {
    public List<String> readFile() {
        Path path = Path.of("input.txt");
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not read the input file");
        }
    }

}
