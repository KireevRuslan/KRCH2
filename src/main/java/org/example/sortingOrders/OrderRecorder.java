package org.example.sortingOrders;

import java.time.LocalDateTime;

public abstract class OrderRecorder {
    protected final LocalDateTime dateOrder;
    protected final String corpName;
    protected final int concreteQuantity;

    protected OrderRecorder(LocalDateTime dateOrder, String corpName, int concreteQuantity) {
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
        return dateOrder + " " + corpName + " " + concreteQuantity;
    }
}
