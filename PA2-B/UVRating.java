/**
 * An enumeration of UV Ratings.
 *
 * @author Prof. David Bernstein, James Madison University
 * @author Chris Mayfield
 * @version 09/06/2021
 */
public enum UVRating {

    INVALID("Invalid", "No information is available.",
            new Interval('(', Double.NEGATIVE_INFINITY, 0, ')')),
    SAFE("Safe", "No action is necessary.", new Interval('[', 0, 1, ')')),
    LOW("Low", "Wear sunscreen and/or protective clothes.",
            new Interval('[', 1, 3, ')')),
    MODERATE("Moderate", "Stay in the shade near midday.",
            new Interval('[', 3, 6, ')')),
    HIGH("High", "Reduce time in the sun.", new Interval('[', 6, 8, ')')),
    VERY_HIGH("Very High", "Stay indoors between 11AM and 4PM.",
            new Interval('[', 8, 11, ')')),
    EXTREME("Extreme", "Stay indoors.",
            new Interval('[', 11, Double.POSITIVE_INFINITY, ')'));

    private final Interval interval;
    private final String action;
    private final String name;

    /**
     * Explicit Value Constructor.
     *
     * @param name The (short) name of this UVRating
     * @param action The recommended action to take
     * @param interval The UV indexes associated with this UVRating
     */
    UVRating(String name, String action, Interval interval) {
        this.interval = interval;
        this.action = action;
        this.name = name;
    }

    /**
     * Get the recommended action for this UVRating.
     *
     * @return The recommended action
     */
    public String getAction() {
        return action;
    }

    /**
     * Get the name of this UVRating.
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the UVRating that corresponds to a particular UVI value.
     *
     * @param uvi The UVI value of interest
     * @return The corresponding UVRating
     */
    public static UVRating ratingFor(double uvi) {
        for (UVRating r : UVRating.values()) {
            if (r.interval.contains(uvi)) {
                return r;
            }
        }
        return INVALID;
    }

    /**
     * Get the UVRating that corresponds to a particular UVI.
     *
     * @param uvi The UV index of interest
     * @return The corresponding UVRating
     */
    public static UVRating ratingFor(UVI uvi) {
        return ratingFor(uvi.getValue());
    }

}
