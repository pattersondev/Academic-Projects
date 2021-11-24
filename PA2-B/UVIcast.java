import java.util.prefs.BackingStoreException;

/**
 * A very rudimentary version of UVIcast that can be used for testing the other
 * classes.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class UVIcast {
    /**
     * The entry point of the application.
     *
     * @param args The command-line arguments (which are ignored)
     */
    public static void main(String[] args) {
        DailyUVReport report;
        DailyUVReport today;
        int first;
        MultiDayWidget window;
        MultiDayUVForecast forecast;

        today = new DailyUVReport(new UVI(8.0, false), new UVI(9.0, false),
                90.0, false);

        if (args.length == 0) {
            first = 0;
        } else {
            try {
                first = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                first = 0;
            }
        }

        forecast = new MultiDayUVForecast(first);

        // Add seven days worth of information to the MultiDayForecast
        // (even though only five will be displayed)
        report = new DailyUVReport(null, null, -1.0, false);
        for (int i = 0; i < 7; i++) {
            UVI high;
            UVI low;

            low = new UVI(i, false);
            high = new UVI(i + 3.0, false);
            report.setConditions(low, high);
            report.setTemperature((first + i) * 10.0);
            if (i % 2 == 0) {
                report.setOvercast(true);
            } else {
                report.setOvercast(false);
            }
            
            try {
                forecast.addDailyUVReport(report);
            } catch (BackingStoreException bse) {
                System.out.println("Unable to add to forecast.");
            }
        }

        // Construct and display the window
        window = new MultiDayWidget(today, forecast);
        window.setVisible(true);
    }
}
