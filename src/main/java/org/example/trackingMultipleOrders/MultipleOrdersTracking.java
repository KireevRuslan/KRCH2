package org.example.trackingMultipleOrders;

import org.example.interfaces.TrackingMultipleOrderInterface;
import org.example.recorders.SaleOrderRecorder;

import java.util.HashMap;
import java.util.LinkedList;

public class MultipleOrdersTracking implements TrackingMultipleOrderInterface {
    @Override
    public HashMap<String, Long> convert(LinkedList<SaleOrderRecorder> saleList) {
        HashMap<String, Long> orderMap = new HashMap<>();
        for (SaleOrderRecorder order : saleList) {
            String corpName = order.getCorpName();
            long saleOrder = order.getSaleOrder();

            orderMap.put(corpName, orderMap.getOrDefault(corpName, 0L) + saleOrder);
        }
        return orderMap;
    }
}
