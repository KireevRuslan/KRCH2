package org.example.sales;

import org.example.recorders.SaleOrderRecorder;
import org.example.recorders.SumOrderRecorder;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SaleOrderTest {
    @Test
    void shouldApplyFirstDiscount() {
        LinkedList<SumOrderRecorder> orders = new LinkedList<>();
        orders.add(new SumOrderRecorder("Kulagin", 1000L));
        SaleOrder saleOrder = new SaleOrder();
        LinkedList<SaleOrderRecorder> result = saleOrder.sale(orders);
        assertEquals(1,result.size());
        assertEquals(700L, result.get(0).getSaleOrder());
        assertEquals("Kulagin",result.get(0).getCorpName());
    }
    @Test
    void shouldDecreaseDiscountForEachOrder(){
        LinkedList<SumOrderRecorder> orders = new LinkedList<>();
        orders.add(new SumOrderRecorder("Kulagin", 1000));
        orders.add(new SumOrderRecorder("Nigaluk", 1000));
        orders.add(new SumOrderRecorder("Kireev", 1000));

        SaleOrder saleOrder = new SaleOrder();

        LinkedList<SaleOrderRecorder> result = saleOrder.sale(orders);

        assertEquals(700L, result.get(0).getSaleOrder());
        assertEquals(730L, result.get(1).getSaleOrder());
        assertEquals(760L, result.get(2).getSaleOrder());

    }
    @Test
    void shouldNotApplyNegativeDiscount(){
        LinkedList<SumOrderRecorder> orders = new LinkedList<>();

        for (int i = 0; i < 12; i++) {
            orders.add(new SumOrderRecorder("Corp" + i, 1000));
        }

        SaleOrder saleOrder = new SaleOrder();

        LinkedList<SaleOrderRecorder> result = saleOrder.sale(orders);

        assertEquals(970L, result.get(9).getSaleOrder());
        assertEquals(1000L, result.get(10).getSaleOrder());
        assertEquals(1000L, result.get(11).getSaleOrder());
    }
    @Test
    void shouldReturnEmptyListForEmptyInput(){
        SaleOrder saleOrder = new SaleOrder();

        LinkedList<SaleOrderRecorder> result = saleOrder.sale(new LinkedList<>());
        assertTrue(result.isEmpty());
    }
    @Test
    void shouldPreserveCompanyNames(){
        LinkedList<SumOrderRecorder> orders = new LinkedList<>();
        orders.add(new SumOrderRecorder("Kulagin", 1000));
        orders.add(new SumOrderRecorder("Kireev", 2000));

        SaleOrder saleOrder = new SaleOrder();

        LinkedList<SaleOrderRecorder> result = saleOrder.sale(orders);

        assertEquals("Kulagin", result.get(0).getCorpName());
        assertEquals("Kireev", result.get(1).getCorpName());
    }
}
