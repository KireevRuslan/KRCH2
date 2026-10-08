package org.example.sortingOrders;

import org.example.recorders.OrderRecorder;
import org.example.interfaces.OrderSortInterface;

import java.util.Comparator;
import java.util.LinkedList;

public class OrderSort implements OrderSortInterface {

    public LinkedList<OrderRecorder> sort (LinkedList<OrderRecorder> orderList) {
        orderList.sort(Comparator.comparing(OrderRecorder::getDateOrder));
        return orderList;
    }



}

