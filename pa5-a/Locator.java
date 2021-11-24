import java.awt.Point;

/**
 * Locator class for pa5.
 * 
 * @author Sam Patterson
 * @version 11/9/2021
 */
public class Locator {
    private Sensor sensor;

    /**
     * Constructor for locator object.
     * 
     * @param sensor to set
     */
    public Locator(Sensor sensor) {
        this.sensor = sensor;
    }

    /**
     * Searches for a certain animal on the map.
     * 
     * @param x coord
     * @param y coord
     * @param width of area
     * @return point of animal found
     */
    public Point search(int x, int y, int width) {
        Point res = new Point(x, y);
        int that = sensor.scan(x, y, width);
        if (that == 1) {
            return res;
        }
        if (that < 0) {
            res = null;
        } else {
            res = search(x, y, width / 2);
            if (res == null) {
                res = search(x + width / 2, y, width / 2);
                if (res == null) {
                    res = search(x, y + width / 2, width / 2);
                    if (res == null) {
                        res = search(x + width / 2, y + width / 2, width / 2);
                    }
                }
            }
        }

        return res;
    }
}
