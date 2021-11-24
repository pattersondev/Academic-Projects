import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

class LocatorTest {

    @Test
    void testLoc() {
        Locator locator;
        Locator locator1;
        Locator locator2;
        Locator locator3;
        Locator locator4;
        Locator locator5;
        
        Point a;
        Point b;
        Point c;
        Point d;
        Point f;
        Point g;
        
        Sensor sensor;
        Sensor sensor1;
        Sensor sensor2;
        Sensor sensor3;
        Sensor sensor4;
        Sensor berny;

        sensor = new Sensor("UL", 0);
        sensor1 = new Sensor("LL", 0);
        sensor2 = new Sensor("UR", 0);
        sensor3 = new Sensor("LR", 0);
        sensor4 = new Sensor("LOL", 0);
        berny = new Sensor("Bernstein", 0);
        
        locator = new Locator(sensor);
        locator1 = new Locator(sensor1);
        locator2 = new Locator(sensor2);
        locator3 = new Locator(sensor3);
        locator4 = new Locator(sensor4);
        locator5 = new Locator(berny);
        
        a = locator.search(0, 0, 512);
        b = locator1.search(0, 0, 512);
        c = locator2.search(0, 0, 512);
        d = locator3.search(0, 0, 512);
        f = locator4.search(0, 0, 512);
        g = locator5.search(0, 0, 512);
        
        assertEquals(new Point(0, 0), a);
        assertEquals(new Point(0, 511), b);
        assertEquals(new Point(511, 0), c);
        assertEquals(null, f);
        assertEquals(new Point(511, 511), d);
        assertEquals(new Point(378, 349), g);
    }

}
