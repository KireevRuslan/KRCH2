package org.example.fileReaders;

import org.example.interfaces.OrderReadInterface;

public class ExtensionlessOrderReaderAdapter implements OrderReadInterface {
    private final ExtensionlessFileReader extensionlessReader;

    public ExtensionlessOrderReaderAdapter(ExtensionlessFileReader extensionlessReader) {
        this.extensionlessReader = extensionlessReader;
    }

    @Override
    public String read(String filePath) {
        return extensionlessReader.readExtensionless(filePath);
    }
}
