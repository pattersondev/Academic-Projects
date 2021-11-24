package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import org.junit.jupiter.api.Test;
import signz.product.ItemizedProduct;

/**
 * Tests the itemized product class.
 * 
 * @author Sam Patterson
 * @version 10/24/2021
 *
 */
class ItemizedProductTest {

    /**
     * Tests the empty constructor.
     */
    @Test
    void testEmptyConstruct() {
        ItemizedProduct test = new ItemizedProduct(1, "test", 1, 1.0, 1, "yes");
        ItemizedProduct test2 = new ItemizedProduct(1, "test", 1, 1.0, 2,
                "yes");
        ItemizedProduct test3 = new ItemizedProduct(1, "test", -1, 1.0, 2,
                "yes");
        assertEquals(test.getAlignment(), SwingConstants.LEFT);
        assertEquals(test.getSize(), 24);
        assertEquals(test.getColor(), Color.BLUE);
        assertEquals(test.getStyle(), Font.BOLD);
        assertEquals(test.getText(), "test $  1.00 yes");
        assertEquals(test2.getText(), "test $  1.00for  2 yes");
        assertEquals(test3.getText(), "test $  1.00for  2 yes (Rain Check)");
        test.getProductNumber();
    }

    /**
     * Tests the is available method.
     */
    @Test
    void testIsAvailable() {
        ItemizedProduct test = new ItemizedProduct(1, "test", 1, 1.0, 1, "yes");
        ItemizedProduct test2 = new ItemizedProduct(0, "test", 0, 0.0, 0,
                "yes");
        assertTrue(test.isAvailable());
        assertFalse(test2.isAvailable());
    }

    /**
     * Tests the change quantity method.
     */
    @Test
    void testChangeQuantityAvailable() {
        ItemizedProduct test = new ItemizedProduct(1, "test", 1, 1.0, 1, "yes");
        test.changeQuantityAvailable(1);
        test.changeQuantityAvailable(-5);
    }

    /**
     * Tests the parse item method.
     */
    @Test
    void testParse() {
        String s = "1,1,1,1,test";
        ItemizedProduct.parseItemizedProduct(s);
    }

}
