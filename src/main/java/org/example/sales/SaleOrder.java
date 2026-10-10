package org.example.sales;

import org.example.interfaces.SalesInterface;
import org.example.recorders.SaleOrderRecorder;
import org.example.recorders.SumOrderRecorder;

import java.util.LinkedList;

public class SaleOrder implements SalesInterface {

    private int saleDecrease = 3;

    @Override
    public LinkedList<SaleOrderRecorder> sale(LinkedList<SumOrderRecorder> result) {
        int salePercent = 30;
        LinkedList<SaleOrderRecorder> saleList = new LinkedList<>();
        for (SumOrderRecorder order : result) {
            long count = order.getSumOrder();
            long saleCount;
            if (salePercent > 0) {
                saleCount = count * (100 - salePercent) / 100;
                salePercent -= saleDecrease;
                if (salePercent < 0) {
                    salePercent = 0;
                }
            } else {
                saleCount = count;
            }
            SaleOrderRecorder saleRecorder = new SaleOrderRecorder(order.getCorpName(), saleCount);
            saleList.add(saleRecorder);
        }
        return saleList;
    }
}
