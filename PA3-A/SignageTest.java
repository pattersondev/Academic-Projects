import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for Signage class.
 * 
 * @author Sam Patterson
 * @version 9/30/2021
 */
class SignageTest {
    /**
     * Tests the constructor.
     */
    @Test
    void testConstructor() {
        FormattedText[] lines = new FormattedText[5];
        Signage test = new Signage("Sam", "Test", lines);
        assertEquals(test.getName(), "Sam");
        assertEquals(test.getCategory(), "Test");
        assertEquals(test.getLines(), lines);
                
    }

}
