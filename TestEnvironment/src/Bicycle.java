

public class Bicycle extends Vehicle implements Comparable<Bicycle>{
    private int gears = 1;

    public Bicycle(double weight, int gears) throws WeightException, 
                                                    GearsException {
        super(weight);
        this.setGears(gears);
    }
    
        public int getGears() {
           // FIXME
        return 100;
    }
    
    // throw and exception if number of gears is less than 1
        public void setGears(int gears) throws GearsException {
         // FIXME
            String msg = "[ERROR] Gears cannot be less or equal to zero";
            throw new GearsException(msg);

    }
    
   // FIXME 
   // take a look at the unit test
   @Override
   public String toString() {

        return "this IS wrong - but I bet you can fix it";
    }
    
   @Override
   public int compareTo( Bicycle c) {

        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        // FIXME you may have to take a look at the unit test

        return EQUAL;
    }
    
     /*
        Bicycle with more gears is better
        If they have the same number of gears, lighter bicycle is better
    */
    @Override
    public boolean isBetter(Object o) {
      // FIXME
      // remember to use isBetter from Vehicle

        return false;
    }
    
        /*
        Bicycle with less gears is better
        If they have the same number of gears, lighter bicycle is better
    */
    @Override
    public boolean isWorst(Object o) {
      // FIXME
      // remember to use isWorst from Vehicle


        return false;
    }
    
    // check with the unit test, to find the information about riding a bicle
    // I bet you would rather ride a bicycle right now!
   @Override
    public boolean needLicense() {
        return true;
    }

  
}