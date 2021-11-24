package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import org.junit.jupiter.api.Test;

import signz.text.FormattedText;

/**
 * Tests the formatted text class.
 * 
 * @author Sam Patterson
 * @version 10/24/2021
 *
 */
class FormattedTextTest {

    /**
     * Tests everything.
     */
    @Test
    void test() {
        FormattedText test = new FormattedText("test", Color.BLACK, 1, 1, 1);
        FormattedText test2 = new FormattedText("Test");
        assertEquals(test2.getAlignment(), SwingConstants.CENTER);
        assertEquals(test2.getColor(), Color.BLACK);
        assertEquals(test2.getSize(), 24);
        assertEquals(test2.getStyle(), Font.PLAIN);
        assertEquals(test2.getText(), "Test");

    }

}
