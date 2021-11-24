import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import org.junit.jupiter.api.Test;

/**
 * Test class for Formatted Text.
 * 
 * @author Sam Patterson
 * @version 9/30/2021
 */
class FormattedTextTest {
    
    /**
     * Tests the five parameter.
     */
    @Test
    void testFiveParamConstruct() {
        FormattedText test = new FormattedText("Test", Color.black, 1, 1, 1);
        assertEquals(test.getText(), "Test");
        assertEquals(test.getColor(), Color.black);
        assertEquals(test.getStyle(), 1);
        assertEquals(test.getSize(), 1);
        assertEquals(test.getAlignment(), 1);
    }
    
    /**
     * Tests the implicit value constructor.
     */
    @Test
    void testOneParamConstruct() {
        FormattedText test = new FormattedText("Test");
        assertEquals(test.getText(), "Test");
        assertEquals(test.getColor(), Color.BLACK);
        assertEquals(test.getStyle(), Font.PLAIN);
        assertEquals(test.getSize(), 24);
        assertEquals(test.getAlignment(), SwingConstants.CENTER);
    }

}
