package org.example.interfaces;

import org.example.recorders.OrderRecorder;
import org.example.recorders.SumOrderRecorder;

import java.util.LinkedList;

public interface OrderCounterInterface {
    public LinkedList<SumOrderRecorder> count (LinkedList<OrderRecorder> orderList, int concretePrice);
    final int concretePrice = 3000;
}
