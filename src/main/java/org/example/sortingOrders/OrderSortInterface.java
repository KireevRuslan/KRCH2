package org.example.sortingOrders;

import org.example.recorders.OrderRecorder;

import java.util.LinkedList;

public interface OrderSortInterface {
    public LinkedList<OrderRecorder> sort (LinkedList<OrderRecorder> orderList);
}
