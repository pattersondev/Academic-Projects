package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.ContainsFilter;

/**
 * Test class for contains filter class.
 * 
 * @author Sam Patterson
 * @version 10/24/2021
 */
class ContainsFilterTest {

    /**
     * Tests the constructor.
     */
    @Test
    void testConstructor() {
        ContainsFilter test = new ContainsFilter("Test", true);
    }

    /**
     * Tests the should pass through method.
     */
    @Test
    void testShouldPassThrough() {
        ContainsFilter test = new ContainsFilter("Test", true);
        ContainsFilter test2 = new ContainsFilter("Test", false);
        ContainsFilter test3 = new ContainsFilter(null, false);
        assertTrue(test.shouldPassThrough("test"));
        assertFalse(test.shouldPassThrough("y"));
        assertTrue(test2.shouldPassThrough("Test"));
        assertFalse(test2.shouldPassThrough("test"));
        assertFalse(test3.shouldPassThrough("e"));
    }

}
