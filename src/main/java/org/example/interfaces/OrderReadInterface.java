package org.example.interfaces;

import org.example.sortingOrders.OrderRecorder;

import java.util.LinkedList;

public interface OrderReadInterface {

    LinkedList<OrderRecorder> read(String filePath);


}
