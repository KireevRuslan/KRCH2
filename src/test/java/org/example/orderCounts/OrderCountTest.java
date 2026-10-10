package org.example.orderCounts;

import org.example.recorders.OrderRecorder;
import org.example.recorders.SumOrderRecorder;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderCountTest {
    private final OrderCount orderCount = new OrderCount();

    @Test
    void shouldCountSingleOrder() {
        LinkedList<OrderRecorder> orders = new LinkedList<>();
        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 10, 12, 30), "Kulagin", 100));
        LinkedList<SumOrderRecorder> result = orderCount.count(orders, 50);

        assertEquals(1, result.size());
        assertEquals("Kulagin", result.getFirst().getCorpName());
        assertEquals(5000L, result.getFirst().getSumOrder());

    }

    @Test
    void shouldHandleNegativeQuantity() {
        LinkedList<OrderRecorder> orders = new LinkedList<>();
        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 10, 12, 30), "Kulagin", -100));
        LinkedList<SumOrderRecorder> result = orderCount.count(orders, 50);
        assertEquals(1, result.size());
        assertEquals("Kulagin", result.getFirst().getCorpName());
        assertEquals(5000L, result.getFirst().getSumOrder());
    }

    @Test
    void shouldReturnEmptyListForEmptyInput() {
        LinkedList<OrderRecorder> orders = new LinkedList<>();
        LinkedList<SumOrderRecorder> result = orderCount.count(orders, 50);
        assertNotNull(result);
        assertTrue(result.isEmpty());


    }

    @Test
    void shouldHandleZeroQuantity() {
        LinkedList<OrderRecorder> orders = new LinkedList<>();
        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 10, 12, 30), "Kulagin", 0));
        LinkedList<SumOrderRecorder> result = orderCount.count(orders, 50);
        assertEquals(1, result.size());
        assertEquals("Kulagin", result.getFirst().getCorpName());
        assertEquals(0L, result.getFirst().getSumOrder());
    }
}
