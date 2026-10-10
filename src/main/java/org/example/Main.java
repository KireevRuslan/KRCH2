package org.example;

import org.example.fileReaders.ExtensionlessReader.ExtensionlessFileReader;
import org.example.orderCounts.OrderCount;
import org.example.sales.SaleOrder;
import org.example.recorders.OrderRecorder;
import org.example.recorders.SaleOrderRecorder;
import org.example.recorders.SumOrderRecorder;
import org.example.resultWriter.TxtWriter;
import org.example.sortingOrders.OrderSort;
import org.example.trackingMultipleOrders.MultipleOrdersTracking;

import java.util.HashMap;
import java.util.LinkedList;

import static org.example.interfaces.OrderCounterInterface.concretePrice;

public class Main {
    static void main(String[] args) {

        LinkedList<SaleOrderRecorder> saleList = getSaleOrderRecorders();
        MultipleOrdersTracking converter = new MultipleOrdersTracking();
        HashMap<String, Long> orderMap = converter.convert(saleList);
        TxtWriter writer = new TxtWriter();
        writer.write(orderMap);
    }

    private static LinkedList<SaleOrderRecorder> getSaleOrderRecorders() {

//        TxtFileReader reader = new TxtFileReader();
        ExtensionlessFileReader reader = new ExtensionlessFileReader();
//        LinkedList<OrderRecorder> orders = reader.readTxt("discount_day.txt");
        LinkedList<OrderRecorder> orders = reader.readExtensionless("discount_day_without_ext");
        OrderSort orderSort = new OrderSort();
        LinkedList<OrderRecorder> sortedOrders = orderSort.sort(orders);
        OrderCount sumOrder = new OrderCount();
        LinkedList<SumOrderRecorder> result = sumOrder.count(sortedOrders, concretePrice);
        SaleOrder saleOrder = new SaleOrder();
        LinkedList<SaleOrderRecorder> saleList = saleOrder.sale(result);

        return saleList;
    }
}

