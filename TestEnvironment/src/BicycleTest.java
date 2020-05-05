package exam3a;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BicycleTest {
    private final double weight = 2.1;
    private final int gears = 2;
    private Bicycle bicycle;

    @Before
    public void setUp() throws Exception {
        bicycle = new Bicycle(weight, gears);
        assertNotNull(bicycle);
    }

    @Test
    public void testToString() {
        String expected = "{ gears='2'}";
        String actual = bicycle.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString1() {
        try {
            int gears = 1;
            Bicycle b = new Bicycle(weight, gears);
            String expected = "{ gear='1'}";
            String actual = b.toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            System.out.println("Exception should not be thrown");
        }
    }

    @Test
    public void testIsBetter() {
        try {
            int newGears = gears + 1;
            Bicycle b = new Bicycle(weight, newGears);
            assertTrue(b.isBetter(bicycle));
            assertFalse(bicycle.isBetter(b));

            double newWeight = weight + 1.0;
            Bicycle bw= new Bicycle(newWeight, gears);
            assertFalse(bw.isBetter(bicycle));
            assertTrue(bicycle.isBetter(bw));

            newWeight = weight;
            bw= new Bicycle(newWeight, gears);
            assertFalse(bw.isBetter(bicycle));

        } catch ( WeightException|GearsException e) {
            System.out.println(e);
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testIsWorst() {
        try {
            // same weight,  bike with less gears is worst
            int newGears = gears + 1;
            Bicycle b = new Bicycle(weight, newGears);
            assertFalse(b.isWorst(bicycle));
            assertTrue(bicycle.isWorst(b));

            // same number of gears, heavier bike is worst
            double newWeight = weight + 1.0;
            Bicycle bw= new Bicycle(newWeight, gears);
            assertTrue(bw.isWorst(bicycle));
            assertFalse(bicycle.isWorst(bw));

            newWeight = weight;
            bw= new Bicycle(newWeight, gears);
            assertFalse(bw.isWorst(bicycle));
        } catch ( WeightException|GearsException e) {
            System.out.println(e);
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testNeedLicense() {
        assertFalse(bicycle.needLicense());
    }
    @Test
    public void testGetGears() {
        int expected = gears;
        int actual = bicycle.getGears();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetGears() {
        try {
            Bicycle b = new Bicycle(2., 2);

            int expected = 3;
            b.setGears(expected);
            int actual = b.getGears();
            assertEquals(expected, actual);

        } catch (GearsException|WeightException e) {
            fail("Should not throw an exception"); 
        }
    }

    @Test
    public void testSetGearsWithException() {
        try {
            Bicycle b = new Bicycle(2., -2);
            fail("Exception should be thrown");
        } catch (GearsException e) {
            assertTrue(true);
        } catch (WeightException e) {
            fail("Weight exception should not be thrown");
        }
    }

    @Test
    public void testCompareTo() {
        try {
            Bicycle b2 = new Bicycle(weight, gears);
            Bicycle b3 = new Bicycle(weight, gears + 1);
            int actual = b3.compareTo(b2);
            int expected = 1;
            assertEquals(expected, actual);

            actual = b2.compareTo(b3);
            expected = -1;
            assertEquals(expected, actual);
        } catch (WeightException | GearsException e) {
            System.out.println(e);
        }

    }

    @Test
    public void testVehicle() {
        try {
            Bicycle b = new Bicycle(2., 3);
            assertNotNull(b);
        } catch (WeightException | GearsException e) {
            System.out.println(e);
            fail("Exception was thrown");
        }
    }

    @Test
    public void testGetWeight() {
        double actual = bicycle.getWeight();
        double expected = weight;
        double delta = 0.001;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void testSetWeight() {
        try {
        double expected = 3.33;
        bicycle.setWeight(expected);
        double actual = bicycle.getWeight();
        double delta = 0.001;
        assertEquals(expected, actual, delta);
        } catch (WeightException e){
            fail("Weight excpetion should not be thrown");
        }
    }

}