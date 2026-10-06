package org.example.fileReaders;

import org.example.interfaces.OrderReadInterface;

public class TxtOrderReaderAdapter implements OrderReadInterface {


    private final TxtFileReader txtReader;

    public TxtOrderReaderAdapter(TxtFileReader txtReader) {
        this.txtReader = txtReader;
    }

    @Override
    public String read(String filePath) {
        return txtReader.readTxt(filePath);
    }
}
