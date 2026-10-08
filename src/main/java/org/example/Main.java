package org.example;

import org.example.fileReaders.ExtensionlessReader.ExtensionlessFileReader;
import org.example.sortingOrders.OrderRecorder;

import java.util.LinkedList;

public class Main {
    static void main(String[] args) {
        ExtensionlessFileReader reader = new ExtensionlessFileReader();
        LinkedList<OrderRecorder>  orders = reader.readExtensionless("discount_day_without_ext");

        for (OrderRecorder order : orders) {
            System.out.println(order);
        }




    }
}
