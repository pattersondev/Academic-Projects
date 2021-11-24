/**
 * A utility class for calculations involving the UltraViolet Index (UVI).
 * 
 * @author Prof. David Bernstein, James Madison University
 * @author Chris Mayfield
 * @version 09/06/2021
 */
public class UVICalculator {

    // Adjustment factors
    private static final double ALTITUDE_ADJUSTMENT = 0.05; // % per km
    private static final double OVERCAST_ADJUSTMENT = -0.50; // %
    private static final double SNOWCOVER_ADJUSTMENT = 0.10; // %

    // Parameters for the Madronich model
    private static final double A = 12.50;
    private static final double D_0 = 300.00;
    private static final double P = 2.42;
    private static final double Q = -1.23;

    // Parameters for the McKinley-Diffey model
    private static final double[] MD_WEIGHTS = {28.65, 3.94, 0.16, 0.03, 0.02};
    private static final double B = 25.0;
    private static final Interval VALID_RADIATION = new Interval('[', 0.0,
            100.0, ']');

    /**
     * Calculate the UVI using a discrete version of the McKinley-Diffey
     * weights. The radiation at 5 different wavelengths is used: 295nm, 310nm,
     * 325nm, 340nm, and 35nm.
     * 
     * Note: This method does validate the parameters. Specifically, radiation
     * values are projected onto the interval [0, 100].
     * 
     * @param radiation The array of radiation values
     * @return The calculated UVI (or null if the array is not of length 5)
     */
    public static UVI calculateUVI(double[] radiation) {
        if (radiation == null || radiation.length != MD_WEIGHTS.length) {
            return null;
        }
        double sum = 0.0;
        for (int i = 0; i < MD_WEIGHTS.length; i++) {
            double r = VALID_RADIATION.closestTo(radiation[i]);
            sum += MD_WEIGHTS[i] * r;
        }
        return new UVI(sum / B, true);
    }

    /**
     * Estimate the UVI based on the solar zenith angle, and the thickness of
     * the ozone layer using the clear-sky, zero-albedo, sea level model in
     * Madronich (2007) and an adjustment for altitude, cloud conditions, and
     * snow cover.
     * 
     * Note: This method does NOT validate the parameters.
     * 
     * @param ozoneThickness The thickness of the ozone layer (in Dobson units)
     * @param angle The solar zenith angle (in degrees)
     * @param altitude The altitude above sea level (in kilometers)
     * @param overcast true if the day is overcast
     * @param snowcover true if there is snow cover
     * 
     * @return The UVI
     */
    public static UVI estimateUVI(double ozoneThickness, double angle,
            double altitude, boolean overcast, boolean snowcover) {
        double mu = Math.cos(Math.toRadians(angle));
        double madronich = A * Math.pow(mu, P)
                * Math.pow(ozoneThickness / D_0, Q);
        double uvi = madronich;
        if (altitude > 0.0) {
            uvi += (altitude * ALTITUDE_ADJUSTMENT) * madronich;
        }
        if (overcast) {
            uvi += OVERCAST_ADJUSTMENT * madronich;
        }
        if (snowcover) {
            uvi += SNOWCOVER_ADJUSTMENT * madronich;
        }
        return new UVI(uvi, false);
    }

    /**
     * Find the maximum (calculated or not) UVI in an array of UVI objects.
     * 
     * @param data The array of UVI objects to consider
     * @param calculated true to consider calculated UVIs; false to consider
     *     not-calculated UVIs
     * @return The maximum value (or Double.NEGATIVE_INFINITY)
     */
    public static double findMaximum(UVI[] data, boolean calculated) {
        Interval range = findRange(data, calculated);
        if (range == null) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return range.getRightEndPoint();
        }
    }

    /**
     * Find the maximum (calculated or not) and minimum UVI values in an array
     * of UVI objects.
     * 
     * @param data The array of UVI objects to consider
     * @param calculated true to consider calculated UVIs; false to consider
     *     not-calculated UVIs
     * @return An Interval containing the range (or null)
     */
    public static Interval findRange(UVI[] data, boolean calculated) {
        if (data == null || data.length == 0) {
            return null;
        }

        // find the max and min in the array
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].isCalculated() == calculated) {
                if (data[i].getValue() > max) {
                    max = data[i].getValue();
                }
                if (data[i].getValue() < min) {
                    min = data[i].getValue();
                }
            }
        }

        // construct and return the result
        Interval result;
        if (min == Double.POSITIVE_INFINITY
                || max == Double.NEGATIVE_INFINITY) {
            result = null;
        } else {
            result = new Interval('[', min, max, ']');
        }
        return result;
    }

}
