package org.example;

import org.example.orderCounts.OrderCount;
import org.example.orderCounts.SaleOrder;
import org.example.recorders.OrderRecorder;
import org.example.fileReaders.TxtReader.TxtFileReader;
import org.example.recorders.SaleOrderRecorder;
import org.example.recorders.SumOrderRecorder;
import org.example.sortingOrders.OrderSort;

import java.util.LinkedList;

import static org.example.interfaces.OrderCounterInterface.concretePrice;

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

        LinkedList<SumOrderRecorder> result =
                sumOrder.count(sortedOrders, concretePrice);

        for (SumOrderRecorder sum : result) {System.out.println(sum);
        }

        SaleOrder saleOrder = new SaleOrder();

        LinkedList<SaleOrderRecorder> saleList = saleOrder.sale(result);
        for(SaleOrderRecorder sales : saleList){
            System.out.println(sales);
        }
    }
}
