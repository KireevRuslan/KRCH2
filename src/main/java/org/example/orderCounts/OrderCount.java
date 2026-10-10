package org.example.orderCounts;

import org.example.recorders.OrderRecorder;
import org.example.interfaces.OrderCounterInterface;
import org.example.recorders.SumOrderRecorder;

import java.util.LinkedList;

public class OrderCount implements OrderCounterInterface {
    @Override
    public LinkedList<SumOrderRecorder> count(LinkedList<OrderRecorder> orderList, int concretePrice) {
        LinkedList<SumOrderRecorder> result = new LinkedList<>();
        for (OrderRecorder order : orderList) {
            int quantity = Math.abs(order.getConcreteQuantity());
            long sumOrder = quantity * concretePrice;

            SumOrderRecorder sumRecorder = new SumOrderRecorder(order.getCorpName(), sumOrder);
            result.add(sumRecorder);

        }
        return result;
    }
}
