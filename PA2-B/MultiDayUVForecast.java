import java.util.prefs.BackingStoreException;

/**
 * Multi Day UV Forecast class for project.
 * 
 * @author Sam Patterson
 * @version 9/7/2021
 *
 */
public class MultiDayUVForecast {
    private static final int CAPACITY = 7;
    private static final String IIOBE_FORMAT = "Day-of-week not in [0, %d].";

    private DailyUVReport[] reports;
    private int firstDayOfWeek;
    private int count = 0;
    private int dayTrack = 0;

    /**
     * Constructor for MultiDayUVForecast object.
     * 
     * @param firstDayOfWeek day of week to start on
     * @throws IndexOutOfBoundsException if int firstDayOfWeek not within
     *     capacity interval
     */
    public MultiDayUVForecast(int firstDayOfWeek)
            throws IndexOutOfBoundsException {
        if (firstDayOfWeek < 0 || firstDayOfWeek >= CAPACITY) {
            throw new IndexOutOfBoundsException(
                    String.format(IIOBE_FORMAT, CAPACITY - 1));
        }
        this.firstDayOfWeek = firstDayOfWeek;
        reports = new DailyUVReport[CAPACITY];
        dayTrack = firstDayOfWeek;

    }

    /**
     * Adds a daily uv report.
     * 
     * @param report to add
     * @throws BackingStoreException to throw
     */
    public void addDailyUVReport(DailyUVReport report)
            throws BackingStoreException {
        if (count == CAPACITY) {
            throw new BackingStoreException("Thing");
        }
        DailyUVReport temp = new DailyUVReport(report.getLow(),
                report.getHigh(), report.getTemperature(), report.isOvercast());
        reports[dayTrack] = temp;
        if (dayTrack >= 6) {
            dayTrack = 0;
        } else {
            dayTrack++;
        }
        count++;
    }

    /**
     * Gets daily UVReport.
     * 
     * @param dow day of the week
     * @return report
     * @throws IndexOutOfBoundsException is thrown
     */
    public DailyUVReport getDailyUVReport(int dow)
            throws IndexOutOfBoundsException {
        if (dow < 0 || dow >= CAPACITY) {
            throw new IndexOutOfBoundsException(
                    String.format(IIOBE_FORMAT, CAPACITY - 1));
        }
        return reports[dow];
    }

    public int getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

}
