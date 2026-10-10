package org.example.sortingOrders;

import org.example.recorders.OrderRecorder;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderSortTest {
    private final OrderSort orderSort = new OrderSort();

    @Test
    void shouldSortOrdersByDate() {
        LinkedList<OrderRecorder> orders = new LinkedList<>();

        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 12, 10, 0),
                "Later", 20));

        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 10, 10, 0),
                "Earlier", 10));

        OrderSort orderSort = new OrderSort();

        LinkedList<OrderRecorder> result = orderSort.sort(orders);

        assertEquals("Earlier", result.get(0).getCorpName());
        assertEquals("Later", result.get(1).getCorpName());
    }
    @Test
    void shouldReturnEmptyList(){
        LinkedList<OrderRecorder> orders = new LinkedList<>();

        OrderSort orderSort = new OrderSort();
        LinkedList<OrderRecorder> result = orderSort.sort(orders);

        assertTrue(result.isEmpty());
    }
    @Test
    void shouldHandleSingleOrder(){
        LinkedList<OrderRecorder> orders = new LinkedList<>();

        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 12, 10, 0),
                "Later", 20));
        OrderSort orderSort = new OrderSort();
        LinkedList<OrderRecorder> result = orderSort.sort(orders);

        assertEquals(1,result.size());
        assertEquals("Later",result.get(0).getCorpName());
        assertEquals(20,result.get(0).getConcreteQuantity());

    }
    @Test
    void shouldKeepCompanyAndQuantityTogether(){
        LinkedList<OrderRecorder> orders = new LinkedList<>();

        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 12, 10, 0),
                "Later", 20));

        orders.add(new OrderRecorder(
                LocalDateTime.of(2026, 10, 10, 10, 0),
                "Earlier", 10));
        OrderSort orderSort = new OrderSort();
        LinkedList<OrderRecorder> result = orderSort.sort(orders);
        assertEquals("Earlier",result.get(0).getCorpName());
        assertEquals(10,result.get(0).getConcreteQuantity());

        assertEquals("Later",result.get(1).getCorpName());
        assertEquals(20,result.get(1).getConcreteQuantity());


    }
}
