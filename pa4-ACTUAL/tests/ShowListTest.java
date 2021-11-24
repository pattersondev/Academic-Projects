package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import signz.Signage;
import signz.ShowList;

/**
 * Test class for show list class.
 * 
 * @author Sam Patterson
 * @version 9/30/2021
 */
class ShowListTest {

    /**
     * Tests the constructor.
     */
    @Test
    void testConstructor() {
        Signage[] signages = new Signage[4];
        ShowList test = new ShowList(signages, "Sam");
        assertEquals(test.getName(), "Sam");
        assertEquals(test.getSize(), 4);
    }

    /**
     * Tests the get size method.
     */
    @Test
    void testGetSize() {
        Signage[] signages = null;
        ShowList test = new ShowList(signages, "Sam");

        assertEquals(test.getSize(), 0);
    }

    /**
     * Tests get next method.
     */
    @Test
    void testGetNext() {
        Signage[] signages = new Signage[3];
        ShowList test = new ShowList(signages, "Sam");
        ShowList test2 = new ShowList(null, null);

        assertEquals(test.getNext(), signages[0]);
        assertEquals(test.getNext(), signages[1]);
        assertEquals(test.getNext(), signages[2]);
        assertEquals(test.getNext(), null);
        assertEquals(test2.getNext(), null);
    }

    /**
     * Tests the reset method.
     */
    @Test
    void testReset() {
        Signage[] signages = new Signage[3];
        ShowList test = new ShowList(signages, "Sam");

        test.reset();
        assertEquals(signages[0], null);

    }

}
