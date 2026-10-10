package org.example.fileReaders.ExtensionlessReader;

import org.example.recorders.OrderRecorder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ExtensionlessFileReader {

    public LinkedList<OrderRecorder> readExtensionless(String filePath) {
        ;
        LinkedList<OrderRecorder> orderList = new LinkedList<>();
        try {
            List<String> orderLine = Files.readAllLines(Path.of(filePath));
            for (String line : orderLine) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                try {
                    if (line.contains("|")) {
                        throw new IllegalArgumentException(
                                "Неправильный разделитель: " + line
                        );
                    }

                    String[] parts = line.split("#");
                    LocalDateTime dateOrder = LocalDateTime.parse(parts[0].trim());
                    String corpName = parts[1].trim();
                    int concreteQuantity = Integer.parseInt(parts[2].trim());

                    OrderRecorder order = new OrderRecorder(dateOrder, corpName, concreteQuantity);

                    orderList.add(order);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }


            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл: " + filePath, e);
        }


        return orderList;
    }
}
