package org.example.recorders;

import org.example.interfaces.RecorderInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderRecorder implements RecorderInterface {
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

    @Override
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
