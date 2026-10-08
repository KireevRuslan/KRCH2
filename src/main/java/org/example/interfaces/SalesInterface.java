package org.example.interfaces;

import org.example.recorders.SaleOrderRecorder;
import org.example.recorders.SumOrderRecorder;

import java.util.LinkedList;

public interface SalesInterface {
    public LinkedList<SaleOrderRecorder> sale (LinkedList<SumOrderRecorder> result);


}
