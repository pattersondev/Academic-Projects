import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for show list class.
 * 
 * @author Sam Patterson
 * @version 9/30/2021
 *
 */
class FilteringShowListTest {
    
    /**
     * Tests constructor.
     */
    @Test
    void testConstructor() {
        Signage[] signages = new Signage[3];
        FilteringShowList test = new FilteringShowList(signages, "Sam", "Test");
        
        assertEquals(test.getName(), "Sam");
        assertEquals(test.getSize(), 3);
    }
    
    /**
     * Tests should show method.
     */
    @Test
    void testShouldShow() {
        Signage[] signages = new Signage[3];
        FilteringShowList test = new FilteringShowList(signages, "Sam", "Test");
        FilteringShowList test2 = new FilteringShowList(signages, "Sam", null);
        
        assertTrue(test.shouldShow("test"));
        assertFalse(test.shouldShow("no"));
        assertFalse(test2.shouldShow("test"));
    }
    
    /**
     * Tests the get next method.
     */
    @Test
    void testGetNext() {
        Signage[] signages = new Signage[3];
        FilteringShowList test = new FilteringShowList(signages, "Sam", "Test");
        FilteringShowList test2 = new FilteringShowList(signages, "Sam", null);
        
        assertEquals(test.getNext(), signages[0]);
        assertEquals(test.getNext(), signages[1]);
        assertEquals(test.getNext(), signages[2]);
        assertEquals(test.getNext(), null);
        assertEquals(test2.getNext(), null);
    }
    
    /**
     * Tests getSize method.
     */
    @Test
    void testGetSize() {
        Signage[] signages = new Signage[3];
        FilteringShowList test = new FilteringShowList(signages, "Sam", null);
        
        assertEquals(test.getSize(), 0);
    }

}
