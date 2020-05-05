

public class Bicycle extends Vehicle implements Comparable<Bicycle>{
    private int gears = 1;

    public Bicycle(double weight, int gears) throws WeightException, GearsException {
        super(weight);
        this.setGears(gears);
    }
    
        public int getGears() {
           // FIXME
        return gears;
    }
    
    // throw and exception if number of gears is less than 1
        public void setGears(int gears) throws GearsException {
         if (gears < 1) {
            String msg = "[ERROR] Gears cannot be less or equal to zero";
            throw new GearsException(msg);
         }
         else this.gears = gears;

    }
    
   // FIXME 
   // take a look at the unit test
   @Override
   public String toString() {

       if(this.gears > 1) {

        return "{ gears='" + this.gears + "'}";

       }

       else {
           return "{ gear='1'}";
       }
    }
    
   @Override
   public int compareTo( Bicycle c) {

        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        
        if (c.getGears() == this.gears) return EQUAL;
        else if (c.getGears() > this.gears) return AFTER;
        else if (c.getGears() < this.gears) return BEFORE;

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
    	if (((Bicycle) o).getGears() < this.gears) return true;
    	else if (((Bicycle) o).getGears() > this.gears) return false;
    	else {
    		if (((Vehicle) o).getWeight() < this.getWeight()) return true;
        	else return false;
    	}
    }
    
        /*
        Bicycle with less gears is better
        If they have the same number of gears, lighter bicycle is better
    */
    @Override
    public boolean isWorst(Object o) {
    	if (((Bicycle) o).getGears() > this.gears) return true;
    	else if (((Bicycle) o).getGears() < this.gears) return false;
    	else {
    		if (((Vehicle) o).getWeight() > this.getWeight()) return true;
        	else return false;
    	}
    }
    
    // check with the unit test, to find the information about riding a bicle
    // I bet you would rather ride a bicycle right now!
   @Override
    public boolean needLicense() {
        return false;
    }

  
}