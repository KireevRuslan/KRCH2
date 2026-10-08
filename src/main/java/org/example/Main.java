package org.example;

import org.example.orderCounts.OrderCount;
import org.example.recorders.OrderRecorder;
import org.example.fileReaders.TxtReader.TxtFileReader;
import org.example.recorders.SumOrderRecorder;
import org.example.sortingOrders.OrderSort;

import java.util.LinkedList;

public class Main {
    static void main(String[] args) {
//        ExtensionlessFileReader reader = new ExtensionlessFileReader();
//        LinkedList<OrderRecorder>  orders = reader.readExtensionless("discount_day_without_ext");
//
//        for (OrderRecorder order : orders) {
//            System.out.println(order);

        TxtFileReader reader = new TxtFileReader();
        LinkedList<OrderRecorder> orders = reader.readTxt("discount_day.txt");

        OrderSort orderSort = new OrderSort();

        LinkedList<OrderRecorder> sortedOrders = orderSort.sort(orders);
        for (OrderRecorder order : orders) {
            //System.out.println(order);

        }

        OrderCount sumOrder = new OrderCount();
        LinkedList<SumOrderRecorder> result = sumOrder.count(orders);


    }
}
