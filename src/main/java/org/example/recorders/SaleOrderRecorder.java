package org.example.recorders;

import org.example.interfaces.RecorderInterface;

public class SaleOrderRecorder implements RecorderInterface {
    private final String corpName;
    private final long saleOrder;

    public SaleOrderRecorder(String corpName, long saleOrder) {
        this.corpName = corpName;
        this.saleOrder = saleOrder;
    }

    @Override
    public String getCorpName() {
        return corpName;
    }

    public long getSaleOrder(){
        return saleOrder;
    }
    @Override
    public String toString() {
        return corpName + " " + saleOrder;
    }
}
