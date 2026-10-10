package org.example.resultWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TxtWriter {
    public void write(HashMap<String, Long> orderMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrdersWithSale.txt"))) {
            for (var entry : orderMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + " руб.");
                writer.newLine();
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
