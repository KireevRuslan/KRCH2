package org.example.fileReaders.ExtensionlessReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExtensionlessFileReader {

    public String readExtensionless(String filePath){
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл: " + filePath, e);
        }
    }
}
