import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private App app;
    @Before
    public void setUp(){
        app = new App();
    }

    @Test
    public void testAscendingIntegers() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        int actual = App.checkOrderingType(integerList);
        int expected = app.getAscendingValue();
        assertEquals(expected, actual);
    }

    @Test
    public void testAscendingIntegersDescription() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        String expected = App.ASCENDING;
        String actual = App.describe(App.checkOrderingType(integerList));
        assertEquals(expected, actual);
    }

    @Test
    public void testDescendingIntegers() {
        List<Integer> integerList = Arrays.asList(4, 3, 2, 1);
        int actual = App.checkOrderingType(integerList);
        int expected = app.getDescendingValue();
        assertEquals(expected, actual);
    }

    @Test
    public void testDescendingIntegersDescription() {
        List<Integer> integerList = Arrays.asList(4, 3, 2, 1);
        String expected = App.DESCENDING;
        String actual = App.describe(App.checkOrderingType(integerList));
        assertEquals(expected, actual);

    }

    @Test
    public void testUnorganizedIntegers()
    {
        List<Integer> integerList = Arrays.asList(4, 2, 3, 1);
        int expected = app.getUnorderedValue();
        int actual = App.checkOrderingType(integerList);
        assertEquals(expected, actual);
    }

    @Test
    public void testDisorganizedIntegersDescription() {
        List<Integer> integerList = Arrays.asList(4, 2, 3, 1);
        String expected = App.UNORGANIZED;
        String actual = App.describe(App.checkOrderingType(integerList));
        assertEquals(expected, actual);

    }

    @Test
    public void testSameIntegers()
    {
        List<Integer> integerList = Arrays.asList(2, 2, 2, 2);
        int expected = app.getSameValue();
        int actual = App.checkOrderingType(integerList);
        assertEquals(expected, actual);
    }

    @Test
    public void testSameIntegersDescirption() {
        List<Integer> integerList = Arrays.asList(2, 2, 2, 2);
        String expected = App.EQUALS;
        String actual = App.describe(App.checkOrderingType(integerList));
        assertEquals(expected, actual);

    }

}