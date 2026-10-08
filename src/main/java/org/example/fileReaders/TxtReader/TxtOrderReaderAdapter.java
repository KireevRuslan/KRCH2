package org.example.fileReaders.TxtReader;

import org.example.interfaces.OrderReadInterface;
import org.example.sortingOrders.OrderRecorder;

import java.util.LinkedList;

public class TxtOrderReaderAdapter implements OrderReadInterface {


    private final TxtFileReader txtReader;

    public TxtOrderReaderAdapter(TxtFileReader txtReader) {
        this.txtReader = txtReader;
    }

    @Override
    public LinkedList<OrderRecorder> read(String filePath) {
        return txtReader.readTxt(filePath);
    }
}
