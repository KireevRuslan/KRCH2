package org.example.interfaces;

import org.example.fileReaders.OrderRecorder;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.TreeMap;

public interface OrderSortInterface {
    public LinkedList<OrderRecorder> sort (LinkedList<OrderRecorder> orderList);
}
