package org.example.recorders;

import org.example.interfaces.RecorderInterface;

import java.time.LocalDateTime;

public class SumOrderRecorder implements RecorderInterface {
    private final String corpName;
    private final long sumOrder;

    public SumOrderRecorder(String corpName, long sumOrder) {
        this.corpName = corpName;
        this.sumOrder = sumOrder;
    }


    @Override
    public String getCorpName() {
        return corpName;
    }


    public long getSumOrder() {
        return sumOrder;
    }

    @Override
    public String toString() {
        return corpName + " " + sumOrder;
    }
}
