package io.vepo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    @DisplayName("Test if it works")
    public void simpleTest() {
        assertEquals("OK", "OK");
    }
}
