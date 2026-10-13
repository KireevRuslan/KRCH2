package org.example.sortingOrders;

import org.example.recorders.OrderRecorder;

import java.util.Comparator;
import java.util.LinkedList;

public class OrderSort implements OrderSortInterface {

    public static final Comparator<OrderRecorder>OrderComporator = Comparator.comparing(OrderRecorder::getDateOrder);

    public LinkedList<OrderRecorder> sort (LinkedList<OrderRecorder> orderList) {
        orderList.sort(OrderComporator);
        return orderList;
    }



}

