import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private double weight = 1.1;
    private double price = 1000.99;
    private Car car;

    @Before
    public void setUp() throws Exception {
        try {
            car = new Car(weight, price);
        } catch (WeightException | PriceException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testToString() {
        String actual = car.toString();
        String expected = "{ weight='1.1', price='1000.99'}";
        assertEquals(expected, actual);
    }

    @Test
    public void testIsBetter() {
        try {
            // better car is more expensive
            // if the price is the same, it is 
            // based on Vehicle isBetter
            double newPrice = price + 100.0;
            Car betterCar = new Car(weight, newPrice);
            assertTrue(betterCar.isBetter(car));
            assertFalse(car.isBetter(betterCar));
        } catch (PriceException | WeightException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testIsWorst() {
        try {
            // worst car is less expensive
            // if the price is the same, it is 
            // based on Vehicle isWorst
            double newPrice = price + 100.0;
            Car betterCar = new Car(weight, newPrice);
            assertTrue(car.isWorst(betterCar));
            assertFalse(betterCar.isWorst(car));
        } catch (PriceException | WeightException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testNeedLicense() {
        assertTrue(car.needLicense());
    }

    @Test
    public void testGetPrice() {
        double expected = price;
        double actual = car.getPrice();
        final double delta = 0.0001;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void testSetPrice() {
        try {
            double expected = 999.99;
            car.setPrice(expected);
            double actual = car.getPrice();
            final double delta = 0.0001;
            assertEquals(expected, actual, delta);

        } catch (PriceException e) {
            fail("Price exception should not be thrown");
        }
    }

    @Test
    public void testCompareTo() {
        try {
            double newPrice = price + 100.0;
            Car c = new Car(10.0, newPrice);

            int actual = c.compareTo(car);
            int expected = 1;

            assertEquals(expected, actual);

        } catch (PriceException | WeightException e) {
            fail("Should not throw an exception");
        }
    }

    @Test
    public void testGetWeight() {
        double actual = car.getWeight();
        double expected = weight;
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testSetWeight() {
        try {
            double newWeight = weight + 100.0;
            Car c = new Car(newWeight, price);

            double actual = c.getWeight();
            double expected = newWeight;

            assertEquals(expected, actual, 0.001);

        } catch (PriceException | WeightException e) {
            fail("Should not throw an exception");
        }
    }
}