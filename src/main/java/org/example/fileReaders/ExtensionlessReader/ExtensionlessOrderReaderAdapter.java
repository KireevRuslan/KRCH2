package org.example.fileReaders.ExtensionlessReader;

import org.example.interfaces.OrderReadInterface;
import org.example.sortingOrders.OrderRecorder;

import java.util.LinkedList;

public class ExtensionlessOrderReaderAdapter implements OrderReadInterface {
    private final ExtensionlessFileReader extensionlessReader;

    public ExtensionlessOrderReaderAdapter(ExtensionlessFileReader extensionlessReader) {
        this.extensionlessReader = extensionlessReader;
    }

    @Override
    public LinkedList<OrderRecorder> read(String filePath) {
        return extensionlessReader.readExtensionless(filePath);
    }
}
