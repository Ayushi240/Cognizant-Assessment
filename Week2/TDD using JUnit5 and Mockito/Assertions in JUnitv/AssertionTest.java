package org.example;  // ✅ Must match your package structure

import org.testng.annotations.Test;          // Import @Test annotation

import static org.testng.AssertJUnit.*;

public class AssertionTest {

    @Test
    public void testAssertions() {
        // ✅ Assert that two values are equal
        assertEquals(5, 2 + 3);

        // ✅ Assert that a condition is true
        assertTrue(5 > 3);

        // ✅ Assert that a condition is false
        assertFalse(5 < 3);

        // ✅ Assert that a value is null
        assertNull(null);

        // ✅ Assert that a value is NOT null
        assertNotNull(new Object());
    }
}
