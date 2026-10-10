package org.example.resultWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TxtWriter {
    private final String filePath;

    public TxtWriter(String filePath) {
        this.filePath = filePath;
    }
    public void write(HashMap<String, Long> orderMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (var entry : orderMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + " руб.");
                writer.newLine();
            }

        } catch (
                IOException e) {
            throw new RuntimeException("Ошибка записи файла", e);
        }
    }
}
