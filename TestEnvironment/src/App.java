import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App 
{
    public static final String  ASCENDING = "ascending values";
    public static final String  DESCENDING = "descending values";
    public static final String  EQUALS = "equal values";
    public static final String  UNORGANIZED = "equal values";
    public static final String  UNEXPECTED = "unexpected values";

    private static final int BEFORE = -1;
    private static final int EQUAL = 0;
    private static  final int AFTER = 1;
    private static final int NORDER = -999; 

    public int getAscendingValue(){
        return BEFORE;
    }

    public int getDescendingValue() {
        return AFTER;
    }

    public int getSameValue() {
        return EQUAL;
    }

    public int getUnorderedValue() {
        return NORDER;
    }

    public static<T extends Comparable<T>> int checkOrderingType(List<T> list){
        // create a List<Integer> and store compareTo values 
        // values are check from first to last
        // Example
        // a.get(0).compareTo(a.get(1))
        // a.get(1).compareTo(a.get(2))
        // and so on

   // FIXME

      List<Integer> comparison = new ArrayList<>();
      for (int i = 0; i < list.size() - 1; ++i) {
    	  comparison.add(list.get(i).compareTo(list.get(i+1)));
      }
        return checkOrder(comparison);
    }
    
   // check with the unit tests
    public static int checkOrder(List<Integer> list ){
        // use set interface
        //
        // if all values of comparing are 1
        //    then it means that we have a descending list
        // if all values of comparing are -1
        //     then it means that we have an ascending list
        // if all values of comparing are 0
        //     it means that all elements are the same
        
        // otherwise return that they have no order

      // FIXME
    	
    	Set<Integer> set = new HashSet<>();
    	for (int i = 0; i < list.size(); ++i) {
    		set.add(list.get(i));
    	}
    	
    	if (set.contains(-1) && !set.contains(1) && !set.contains(0)) return AFTER;
    	else if (set.contains(1) && !set.contains(-1) && !set.contains(0)) return BEFORE;
    	else if (set.contains(0) && !set.contains(1) && !set.contains(-1)) return EQUAL;
    	else return NORDER;
    }

   // check with the unit tests
    public static String describe(int value){
      //FIXME
    	if (value == -1) return ASCENDING;
    	else if (value == 1) return DESCENDING;
    	else if (value == 0) return EQUALS;
    	else if (value == -999) return UNORGANIZED;
    	else return UNEXPECTED;
    }
    
    public static void main( String[] args )
    {
        System.out.println("Hello Fellow Programmer!");
         System.out.println("Normally, we test programs, but now, we are testing programmers testing programs!");


        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        System.out.println(checkOrderingType(integerList));
        System.out.println(describe(checkOrderingType(integerList)));

        List<Double> doubleList = Arrays.asList(4.4, 3.3, 2.2, 1.1);
        System.out.println(checkOrderingType(doubleList));
        System.out.println(describe(checkOrderingType(doubleList)));

        List<String> strList = Arrays.asList("4.4", "3.3", "2.2", "1.1");
        System.out.println(checkOrderingType(strList));
        System.out.println(describe(checkOrderingType(strList)));

        strList = Arrays.asList("a", "b", "c", "d");
        System.out.println(checkOrderingType(strList));
        System.out.println(describe(checkOrderingType(strList)));

        strList = Arrays.asList("a", "a", "a", "a");
        System.out.println(checkOrderingType(strList));
        System.out.println(describe(checkOrderingType(strList)));

        try {
            List<Car> cars = new ArrayList<>();
            double price = 100.;
            double weight = 1000.;
            cars.add(new Car(weight, price));

            price = price + 100.;
            weight = weight + 100.;

            cars.add(new Car(weight, price));

            price = price + 100.;
            weight = weight + 100.;
            cars.add(new Car(weight, price));

            System.out.println(checkOrderingType(cars));
            System.out.println(describe(checkOrderingType(cars)));
        } catch (PriceException e) {
            System.out.println(e);
        } catch (WeightException e) {
            System.out.println(e);
        }
    }
}