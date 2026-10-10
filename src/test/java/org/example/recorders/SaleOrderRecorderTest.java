package org.example.recorders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SaleOrderRecorderTest {
    @Test
    void shouldCreateSaleOrderRecorder() {
        SaleOrderRecorder recorder = new SaleOrderRecorder("Kulagin", 23937000L);

        assertNotNull(recorder);
        assertEquals("Kulagin", recorder.getCorpName());
        assertEquals(23937000L, recorder.getSaleOrder());
    }

    @Test
    void shouldFormatToString() {
        SaleOrderRecorder recorder = new SaleOrderRecorder("Kulagin", 23937000L);
        assertEquals(
                "Kulagin 23937000",
                recorder.toString());

    }
}
