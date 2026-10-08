package org.example.interfaces;

import org.example.recorders.OrderRecorder;

import java.util.LinkedList;

public interface OrderReadInterface {

    LinkedList<OrderRecorder> read(String filePath);


}
