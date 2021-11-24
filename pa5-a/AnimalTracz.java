import java.awt.Point;

/**
 * The main class for AnimalTracz.
 * 
 * @author M. Perkins
 * @version 1.0
 */
public class AnimalTracz {
    /**
     * The entry point of the application.
     * 
     * Notes: args[0] is the name of the animal to search for args[1] is the
     * optional scantime (in milliseconds)
     * 
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Locator locator;
        int scanTime;
        Point result;
        Sensor sensor;

        if (args == null || args.length == 0) {
            System.out.println("You didn't tell me what animal to locate.");
            System.out.println("Please use the following syntax: ");
            System.out.println("     AnimalTracz animal [scantime]");
            System.out.println("where the animal is not in quotes and "
                    + "the scantime is in milliseconds.");
        } else {
            scanTime = 0;

            if (args.length > 1) {
                try {
                    scanTime = Integer.parseInt(args[1]);
                } catch (NumberFormatException nfe) {
                    scanTime = 1000; // 1000 milliseconds (i.e., 1 second)
                }
            }

            sensor = new Sensor(args[0], scanTime);

            locator = new Locator(sensor);
            result = locator.search(0, 0, 512);

            System.out.print(args[0] + " ");
            if (result == null) {
                System.out.println("not located.");
            } else {
                System.out.println("located at " + result.x + "," + result.y);
            }
            System.out.println("");
            System.out.println(sensor.checkSystem());
        }
    }
}
