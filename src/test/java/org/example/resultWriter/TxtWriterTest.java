package org.example.resultWriter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TxtWriterTest {
    @TempDir
    Path tempDir;

    @Test
    void shouldWriteSingleEntry() throws Exception {
        Path file = tempDir.resolve("result.txt");
        TxtWriter writer = new TxtWriter(file.toString());
        HashMap<String, Long> map = new HashMap<>();
        map.put("Kulagin", 23937000L);
        writer.write(map);
        assertEquals(List.of("Kulagin 23937000 руб."), Files.readAllLines(file));


    }

    @Test
    void shouldWriteMultipleEntries() throws Exception {
        Path file = tempDir.resolve("result.txt");
        TxtWriter writer = new TxtWriter(file.toString());

        HashMap<String, Long> map = new HashMap<>();
        map.put("Kulagin", 23937000L);
        map.put("Andrey", 10046400L);

        writer.write(map);

        List<String> lines = Files.readAllLines(file);

        assertEquals(2, lines.size());
        assertTrue(lines.contains("Kulagin 23937000 руб."));
        assertTrue(lines.contains("Andrey 10046400 руб."));

    }
    @Test
    void shouldCreateEmptyFileForEmptyMap()throws Exception{
        Path file = tempDir.resolve("result.txt");
        TxtWriter writer = new TxtWriter(file.toString());

        writer.write(new HashMap<>());

        assertTrue(Files.exists(file));
        assertTrue(Files.readAllLines(file).isEmpty());
    }
    @Test
    void shouldOverwriteExistingFile() throws Exception{
        Path file = tempDir.resolve("result.txt");
        Files.writeString(file, "Старое содержимое");

        TxtWriter writer = new TxtWriter(file.toString());

        HashMap<String, Long> map = new HashMap<>();
        map.put("Kulagin", 100L);

        writer.write(map);

        assertEquals(List.of("Kulagin 100 руб."), Files.readAllLines(file)
        );

    }

}
