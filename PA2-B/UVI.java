/**
 * An encapsulation of an ultraviolet index.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @author Chris Mayfield
 * @version 09/06/2021
 */
public class UVI {

    private static final String DEFAULT_FORMAT = "%2.0f";
    private static final Interval PRINTABLE = new Interval('[', 0, 100, ')');
    private static final Interval VALID = new Interval('[', 0,
            Double.POSITIVE_INFINITY, ')');

    private final boolean calculated;
    private final double value;

    /**
     * Explicit Value Constructor.
     * 
     * @param value The value of the UVI
     * @param calculated true if the value is calculated from measured radiation
     *     levels
     */
    public UVI(double value, boolean calculated) {
        this.calculated = calculated;
        this.value = VALID.closestTo(value);
    }

    /**
     * Get the value.
     * 
     * @return The value
     */
    public double getValue() {
        return value;
    }

    /**
     * Is the value calculated from measured radiation levels?.
     *
     * @return true if the value is calculated from measured radiation levels
     */
    public boolean isCalculated() {
        return calculated;
    }

    /**
     * Return a String representation of the value (rounded to the nearest
     * integer, in a field of width 2) or "NA" if the value is greater than or
     * equal to 100.0.
     * 
     * @return The String representation
     */
    @Override
    public String toString() {
        if (PRINTABLE.contains(value)) {
            return String.format(DEFAULT_FORMAT, value);
        } else {
            return "NA";
        }
    }

}
