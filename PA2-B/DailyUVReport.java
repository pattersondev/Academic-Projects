/**
 * Daily UV Report class for project.
 * 
 * @author Sam Patterson
 * @version 9/7/2021
 *
 */
public class DailyUVReport {
    private static final String DEFAULT_FORMAT = "UVI: %2.0f - %2.0f";
    private static final UVI DEFAULT_HIGH = new UVI(8.9, false);
    private static final UVI DEFAULT_LOW = new UVI(6.3, false);
    private static final Interval VALID_TEMPERATURES = new Interval('[', -50.0,
            120.0, ']');

    private boolean overcast;
    private double temperature;
    private UVI high;
    private UVI low;

    /**
     * Constructor for the Daily UV Report object.
     * 
     * @param low UVI
     * @param high UVI
     * @param temperature of day
     * @param overcast of day
     */
    public DailyUVReport(UVI low, UVI high, double temperature,
            boolean overcast) {
        setConditions(low, high);
        setTemperature(temperature);
        setOvercast(overcast);
    }

    /**
     * Getter.
     * 
     * @return thing
     */
    public UVI getHigh() {
        return high;
    }

    /**
     * Getter.
     * 
     * @return thing
     */
    public UVI getLow() {
        return low;
    }

    public String getRange() {
        return String.format(DEFAULT_FORMAT, low.getValue(), high.getValue());
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isOvercast() {
        return overcast;
    }

    public void setOvercast(boolean overcast) {
        this.overcast = overcast;
    }

    public void setTemperature(double temperature) {
        this.temperature = VALID_TEMPERATURES.closestTo(temperature);
    }

    /**
     * Sets conditions for the day.
     * 
     * @param lowUVI does things
     * @param highUVI does things
     */
    public void setConditions(UVI lowUVI, UVI highUVI) {
        if (lowUVI == null) {
            this.low = DEFAULT_LOW;
        } else {
            this.low = lowUVI;
        }

        if (highUVI == null) {
            this.high = DEFAULT_HIGH;
        } else {
            this.high = highUVI;
        }

        if (low.getValue() > high.getValue()) {
            low = DEFAULT_LOW;
            high = DEFAULT_HIGH;
        }
    }

}
