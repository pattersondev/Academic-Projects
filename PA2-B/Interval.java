/**
 * An immutable encapsulation of an interval (that can be open, closed, or
 * half-open/closed.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @author Chris Mayfield
 * @version 09/06/2021
 */
public class Interval {

    private static final String DEFAULT_FORMAT = "%5.1f";

    private final boolean leftClosed;
    private final boolean rightClosed;
    private final double left;
    private final double right;

    /**
     * Construct an open interval.
     *
     * @param left The lower bound
     * @param right The upper bound
     */
    public Interval(double left, double right) {
        this.leftClosed = false;
        this.rightClosed = false;
        this.left = left;
        this.right = right;
    }

    /**
     * Construct an interval.
     *
     * @param leftSymbol [ or (
     * @param left The lower bound
     * @param right The upper bound
     * @param rightSymbol ] or )
     */
    public Interval(char leftSymbol, double left, double right,
            char rightSymbol) {
        this.leftClosed = leftSymbol == '[';
        this.rightClosed = rightSymbol == ']';
        this.left = left;
        this.right = right;
    }

    /**
     * Copy constructor.
     *
     * @param original The Interval to copy
     */
    public Interval(Interval original) {
        this.leftClosed = original.leftClosed;
        this.rightClosed = original.rightClosed;
        this.left = original.left;
        this.right = original.right;
    }

    /**
     * Returns true if the given number is contained in this Interval and false
     * otherwise.
     *
     * Note that this method does not use tolerances. Hence, it is not
     * appropriate for some kinds of calculations.
     *
     * @param number The number to check
     * @return true if the number is in the interval; false otherwise
     */
    public boolean contains(double number) {
        return (left < number && number < right)
                || (leftClosed && number == left)
                || (rightClosed && number == right);
    }

    /**
     * Returns the value in the closure of the Interval (i.e., the Interval and
     * its end points) that is closest to the given number. In other words,
     * projects number onto the closure of this Interval using a minimum
     * Euclidean distance projection.
     *
     * @param number The number of interest
     * @return The value in the closure that is closest to the number
     */
    public double closestTo(double number) {
        double result;
        if (number < left) {
            result = left;
        } else if (number > right) {
            result = right;
        } else {
            result = number;
        }
        return result;
    }

    /**
     * Get the left end point.
     *
     * @return The left end point
     */
    public double getLeftEndPoint() {
        return left;
    }

    /**
     * Get the right end point.
     *
     * @return The right end point
     */
    public double getRightEndPoint() {
        return right;
    }

    /**
     * Is the left end point in this Interval.
     *
     * @return true if it is in this Interval; false otherwise
     */
    public boolean isLeftEndPointIn() {
        return leftClosed;
    }

    /**
     * Is the right end point in this Interval.
     *
     * @return true if it is in this Interval; false otherwise
     */
    public boolean isRightEndPointIn() {
        return rightClosed;
    }

    /**
     * Get a string representation of this Interval.
     * 
     * @param format The format to use (e.g., "%4.2f")
     * @return The String representation
     */
    public String toString(String format) {
        StringBuilder sb = new StringBuilder();

        if (leftClosed) {
            sb.append('[');
        } else {
            sb.append('(');
        }

        sb.append(String.format(format, left));
        sb.append(',');
        sb.append(String.format(format, right));

        if (rightClosed) {
            sb.append(']');
        } else {
            sb.append(')');
        }

        return sb.toString();
    }

    /**
     * Get a String representation of this Interval using the default format.
     * 
     * @return The String representation
     */
    @Override
    public String toString() {
        return toString(DEFAULT_FORMAT);
    }

}
