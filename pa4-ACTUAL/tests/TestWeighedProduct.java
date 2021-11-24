package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import signz.product.WeighedProduct;

/**
 * Tests the weighed product class.
 * 
 * @author Sam Patterson
 * @version 10/24/2021
 * 
 */
class TestWeighedProduct {

    /**
     * Tests the constructor.
     */
    @Test
    void testConstructor() {
        WeighedProduct test = new WeighedProduct(1, "test", 1.0, 1.0);
    }

    /**
     * Tests change ounces available method.
     */
    @Test
    void testChangeAvail() {
        WeighedProduct test = new WeighedProduct(1, "test", 1.0, 1.0);
        WeighedProduct test2 = new WeighedProduct(-1, "test", -1.0, -1.0);
        test.changeOuncesAvailable(1.0);
        test2.changeOuncesAvailable(-5.0);
        assertTrue(test.isAvailable());
        assertFalse(test2.isAvailable());
        test.getAlignment();
        test.getColor();
        test.getProductNumber();
        test.getSize();
        test.getStyle();
    }

    /**
     * Tests the get price description method.
     */
    @Test
    void testGetPriceDesc() {
        WeighedProduct test = new WeighedProduct(1, "test", 1.0, 1.0);
        assertEquals(test.getText(), "test $  1.00 per ounce");
    }

    /**
     * Tests the parse method.
     */

    @Test
    void testParse() {
        String s = "1, 1.0, test, 1.0";
        WeighedProduct.parseWeighedProduct(s);
    }

}
