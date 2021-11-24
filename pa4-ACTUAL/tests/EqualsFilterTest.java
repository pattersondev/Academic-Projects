package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.EqualsFilter;

/**
 * Test cases for equals filter class.
 * 
 * @author Sam Patterson
 * @version 10/24/2021
 *
 */
class EqualsFilterTest {

    /**
     * Tests the constructor.
     */
    @Test
    void testConstructor() {
        EqualsFilter test = new EqualsFilter("Test");
    }

    /**
     * Tests the should pass through method.
     */
    @Test
    void testShouldPassThrough() {
        EqualsFilter test = new EqualsFilter("Test");
        EqualsFilter test3 = new EqualsFilter(null);
        assertTrue(test.shouldPassThrough("Test"));
        assertFalse(test.shouldPassThrough("y"));
        assertFalse(test3.shouldPassThrough("e"));
    }

}
