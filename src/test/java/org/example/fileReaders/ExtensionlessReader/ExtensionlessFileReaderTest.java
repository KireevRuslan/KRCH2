package org.example.fileReaders.ExtensionlessReader;

import org.example.recorders.OrderRecorder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExtensionlessFileReaderTest {
    @TempDir
    Path tempDir;

    @Test
    void shouldReadValidOrder() throws Exception {
        Path file = tempDir.resolve("orders.txt");

        Files.writeString(
                file,
                "2026-10-10T12:30:00#Kulagin#100"
        );

        ExtensionlessFileReader reader =
                new ExtensionlessFileReader();

        LinkedList<OrderRecorder> orders =
                reader.readExtensionless(file.toString());

        assertEquals(1, orders.size());
    }

    @Test
    void shouldSkipEmptyLines() throws Exception {
        Path file = tempDir.resolve("orders.txt");

        Files.writeString(
                file,
                "\n" +
                        "2026-10-10T12:30:00#Kulagin#100" +
                        "\n");
        ExtensionlessFileReader reader =
                new ExtensionlessFileReader();

        LinkedList<OrderRecorder> orders =
                reader.readExtensionless(file.toString());

        assertEquals(1, orders.size());
    }

    @Test
    void shouldSkipInvalidQuantity() throws Exception {
        Path file = tempDir.resolve("orders.txt");

        Files.writeString(
                file,

                "2026-10-10T12:30:00#Kulagin#asd"
        );
        ExtensionlessFileReader reader =
                new ExtensionlessFileReader();

        LinkedList<OrderRecorder> orders =
                reader.readExtensionless(file.toString());

        assertTrue(orders.isEmpty());
    }

    @Test
    void shouldSkipInvalidDate() throws Exception {
        Path file = tempDir.resolve("orders.txt");

        Files.writeString(
                file,

                "2026-10-1012:30:00#Kulagin#100"
        );
        ExtensionlessFileReader reader =
                new ExtensionlessFileReader();

        LinkedList<OrderRecorder> orders =
                reader.readExtensionless(file.toString());

        assertTrue(orders.isEmpty());

    }

    @Test
    void shouldSkipInvalidFieldCount() throws Exception {
        Path file = tempDir.resolve("orders.txt");

        Files.writeString(
                file,

                "2026-10-10T12:30:00#Kulagin"
        );
        ExtensionlessFileReader reader =
                new ExtensionlessFileReader();

        LinkedList<OrderRecorder> orders =
                reader.readExtensionless(file.toString());

        assertTrue(orders.isEmpty());
    }

    @Test
    void shouldSkipWrongDelimiter() throws Exception {
        Path file = tempDir.resolve("orders.txt");

        Files.writeString(
                file,

                "2026-10-10T12:30:00|Kulagin|100"
        );
        ExtensionlessFileReader reader =
                new ExtensionlessFileReader();

        LinkedList<OrderRecorder> orders =
                reader.readExtensionless(file.toString());

        assertTrue(orders.isEmpty());
    }

    @Test
    void shouldReturnEmptyListForEmptyFile() throws Exception {
        Path file = tempDir.resolve("orders.txt");

        Files.writeString(
                file,

                ""
        );
        ExtensionlessFileReader reader =
                new ExtensionlessFileReader();

        LinkedList<OrderRecorder> orders =
                reader.readExtensionless(file.toString());

        assertTrue(orders.isEmpty());

    }

}
