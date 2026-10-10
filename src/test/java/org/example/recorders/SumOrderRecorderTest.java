package org.example.recorders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SumOrderRecorderTest {
    @Test
    void shouldCreateSumOrderRecorder() {
        SumOrderRecorder recorder = new SumOrderRecorder("Kulagin", 23937000L);

        assertNotNull(recorder);
        assertEquals("Kulagin", recorder.getCorpName());
        assertEquals(23937000L, recorder.getSumOrder());
    }

    @Test
    void shouldFormatToString() {
        SumOrderRecorder recorder = new SumOrderRecorder("Kulagin", 23937000L);
        assertEquals(
                "Kulagin 23937000",
                recorder.toString());

    }
}
