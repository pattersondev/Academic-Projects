package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import signz.Displayable;
import signz.FilteringShowList;
import signz.Signage;
import signz.text.FormattedText;
import utilities.ContainsFilter;
import utilities.StringFilter;

/**
 * Test class for filtering show list.
 * 
 * @author Sam Patterson
 * @version 10/25/2021
 */
class FilteringShowListTest {

    /**
     * Tests the constructor.
     */
    @Test
    void testConstruct() {
        FormattedText[] lines = new FormattedText[5];
        Signage test = new Signage("Sam", "Test", lines);
        Signage[] signages = new Signage[5];
        for (int i = 0; i < signages.length; i++) {
            signages[i] = new Signage("", "", new Displayable[4]);
        }
        StringFilter filter = null;
        StringFilter filter2 = new ContainsFilter(" ", true);
        FilteringShowList test2 = new FilteringShowList(signages, " ", filter);
        FilteringShowList test3 = new FilteringShowList(signages, " ", filter2);
        test2.getSize();
        signages[2] = null;
        assertEquals(null, test2.getNext());
        assertEquals(signages[0], test3.getNext());
        assertEquals(signages[1], test3.getNext());
        assertEquals(null, test3.getNext());
    }

}
