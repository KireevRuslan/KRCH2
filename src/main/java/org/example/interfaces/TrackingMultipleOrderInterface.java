package org.example.interfaces;

import org.example.recorders.SaleOrderRecorder;


import java.util.HashMap;
import java.util.LinkedList;

public interface TrackingMultipleOrderInterface {
    public HashMap<String, Long> convert(LinkedList<SaleOrderRecorder> saleList);
}
