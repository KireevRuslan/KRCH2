package org.example.fileReaders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderRecorder {
    protected final LocalDateTime dateOrder;
    protected final String corpName;
    protected final int concreteQuantity;

    public OrderRecorder(LocalDateTime dateOrder, String corpName, int concreteQuantity) {
        this.dateOrder = dateOrder;
        this.corpName = corpName;
        this.concreteQuantity = concreteQuantity;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public String getCorpName() {
        return corpName;
    }

    public int getConcreteQuantity() {
        return concreteQuantity;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateOrder.format(dtf) + " " + corpName + " " + concreteQuantity;
    }
}
