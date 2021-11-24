package signz;

/**
 * Show List class for pa3.
 * 
 * @author Sam Patterson
 * @version 9/29/2021
 */
public class ShowList {
    private Signage[] signages;
    private String name;
    private int nextCount = -1;

    /**
     * ShowList constructor.
     * 
     * @param signages thing
     * @param name thing
     */
    public ShowList(Signage[] signages, String name) {
        this.signages = signages;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Gets the next object in array.
     * 
     * @return next object
     */
    public Signage getNext() {
        if (signages == null || nextCount >= signages.length - 1) {
            return null;
        }
        nextCount += 1;
        return signages[nextCount];
    }

    /**
     * Gets the size of signages.
     * 
     * @return size
     */
    public int getSize() {
        if (signages == null) {
            return 0;
        }
        return signages.length;
    }

    /**
     * Resets the array.
     */
    public void reset() {
        nextCount = -1;
    }

}
