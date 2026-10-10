package org.example.trackingMultipleOrders;

import org.example.recorders.SaleOrderRecorder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleOrdersTrackingTest {
    @Test
    void shouldConvertSingleOrder() {
        LinkedList<SaleOrderRecorder> saleList = new LinkedList<>();
        saleList.add(new SaleOrderRecorder("Kireev", 1000));

        MultipleOrdersTracking tracking = new MultipleOrdersTracking();

        HashMap<String, Long> result = tracking.convert(saleList);

        assertEquals(1, result.size());
        assertEquals(1000L, result.get("Kireev"));

    }

    @Test
    void shouldSumOrdersForSameCompany() {
        LinkedList<SaleOrderRecorder> saleList = new LinkedList<>();
        saleList.add(new SaleOrderRecorder("Kireev", 1000));
        saleList.add(new SaleOrderRecorder("Kireev", 1000));

        MultipleOrdersTracking tracking = new MultipleOrdersTracking();

        HashMap<String, Long> result = tracking.convert(saleList);

        assertEquals(2000L,result.get("Kireev"));
    }
    @Test
    void shouldKeepDifferentCompaniesSeparate(){
        LinkedList<SaleOrderRecorder> saleList = new LinkedList<>();
        saleList.add(new SaleOrderRecorder("Kireev", 1000));
        saleList.add(new SaleOrderRecorder("Kireev", 1000));
        saleList.add(new SaleOrderRecorder("Kureev", 1000));
        MultipleOrdersTracking tracking = new MultipleOrdersTracking();

        HashMap<String, Long> result = tracking.convert(saleList);
        assertEquals(2,result.size());
        assertEquals(2000L,result.get("Kireev"));
        assertEquals(1000L,result.get("Kureev"));
    }

    @Test
    void shouldReturnEmptyMapForEmptyList(){LinkedList<SaleOrderRecorder> saleList = new LinkedList<>();
        MultipleOrdersTracking tracking = new MultipleOrdersTracking();

        HashMap<String, Long> result = tracking.convert(saleList);
        assertTrue(result.isEmpty());

    }
}
