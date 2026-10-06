package org.example.fileReaders.TxtReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TxtFileReader {
    public String readTxt(String filePath){
        try {
            return Files.readString(Path.of(filePath));
            } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл: " + filePath, e);
        }
    }
}
