package signz;

/**
 * Signage class for pa3.
 * 
 * @author Sam Patterson
 * @version 9/29/2021
 */
public class Signage {
    private Displayable[] lines;
    private String category;
    private String name;

    /**
     * Constructor for signage object.
     * 
     * @param name of object
     * @param category of object
     * @param lines of object
     */
    public Signage(String name, String category, Displayable[] lines) {
        this.name = name;
        this.category = category;
        this.lines = lines;
    }

    public Displayable[] getLines() {
        return lines;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
