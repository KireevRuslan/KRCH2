package org.example.fileReaders.TxtReader;

import org.example.recorders.OrderRecorder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class TxtFileReader {

    public LinkedList<OrderRecorder> readTxt(String filePath) {

        LinkedList<OrderRecorder> orderList = new LinkedList<>();
        try {
            List<String> orderLine = Files.readAllLines(Path.of(filePath));

            for (String line : orderLine) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                OrderRecorder parseLine = parseOrderLine(line);
                if (parseLine != null) {
                    orderList.add(parseLine);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл: " + filePath, e);
        }
        return orderList;
    }

    private OrderRecorder parseOrderLine(String line) {

        if (line.contains("\\|")) {
            System.out.println(
                    "Неправильный разделитель: " + line
            );
            return null;
        }

        String[] parts = line.split("\\|", -1);
        if (parts.length != 3) {
            System.out.println("Ошибка: должно быть 3 поля: " + line);
            return null;
        }
        try {
            LocalDateTime dateOrder = LocalDateTime.parse(parts[0].trim());
            String corpName = parts[1].trim();
            int concreteQuantity = Integer.parseInt(parts[2].trim());
            return new OrderRecorder(dateOrder, corpName, concreteQuantity);

        } catch (DateTimeException e) {
            System.out.println("Неверный формат даты: " + parts[0]);
        } catch (NumberFormatException e) {
            System.out.println("Неверное Количество" + parts[2]);
        }

        return null;
    }
}
