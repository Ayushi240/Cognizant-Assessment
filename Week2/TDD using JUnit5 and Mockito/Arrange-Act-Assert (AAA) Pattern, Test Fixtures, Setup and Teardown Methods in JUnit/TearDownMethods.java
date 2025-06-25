package org.example;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.testng.AssertJUnit.*;

public class TearDownMethods {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Setup: runs before each test
        calculator = new Calculator();
        System.out.println("Setup complete.");
    }

    @After
    public void tearDown() {
        // Teardown: runs after each test
        calculator = null;
        System.out.println("Teardown complete.");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);
    }
}