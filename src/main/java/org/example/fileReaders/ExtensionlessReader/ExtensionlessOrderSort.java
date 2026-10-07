package org.example.fileReaders.ExtensionlessReader;

import org.example.interfaces.OrderReadInterface;
import org.example.interfaces.OrderSortInterface;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class ExtensionlessOrderSort implements OrderSortInterface {
    private final String conterpartlyName;
    public final int concreteQuantity;

    ExtensionlessFileReader extensionlessFileReader = new ExtensionlessFileReader();
    OrderReadInterface read = new ExtensionlessOrderReaderAdapter(extensionlessFileReader);
    String result = extensionlessFileReader.readExtensionless("discount_day_without_ext");


    public ExtensionlessOrderSort(String conterpartlyName, int concreteQuantity) {
        this.conterpartlyName = conterpartlyName;
        this.concreteQuantity = concreteQuantity;
    }
    @Override
    public String toString() {
        return conterpartlyName + "|" + concreteQuantity;
    }

    public void TreemapListener(String[] args) {
        TreeMap<LocalDateTime,ExtensionlessOrderSort> events = new TreeMap<>();
        result = extensionlessFileReader.readExtensionless("discount_day_without_ext");

    }
}
