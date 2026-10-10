package org.example.recorders;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderRecorderTest {
    @Test
    void shouldCreateOrderRecorder(){
        LocalDateTime date = LocalDateTime.of(2026, 10, 11, 12, 30, 0);
        OrderRecorder orderRecorder = new OrderRecorder(date, "Kulagin", 100);
        assertNotNull(orderRecorder);
        assertEquals(date, orderRecorder.getDateOrder());
        assertEquals("Kulagin", orderRecorder.getCorpName());
        assertEquals(100, orderRecorder.getConcreteQuantity());
    }
    @Test
    void shouldFormatToString(){
        OrderRecorder order = new OrderRecorder(
                LocalDateTime.of(2026, 10, 11, 12, 30, 0), "Kulagin", 100);

        assertEquals(
                "11/10/2026 12:30:00 Kulagin 100",
                order.toString());
    }

}
