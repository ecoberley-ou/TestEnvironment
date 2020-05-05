


public class Car extends Vehicle implements Comparable<Car>{
    private double price;

    public Car(double weight, double price) throws PriceException, WeightException {
        super(weight);
        this.setPrice(price);
    }
    
        public double getPrice() {
        return price;
    }
    
    // if the price is negative throw an exception
        public void setPrice(double price) throws PriceException {
        	if (price < 0) {
        		String msg = "[ERROR] Price cannot be negative";
        		throw new PriceException(msg);
        	}
        	else this.price = price;
    }
    
        @Override
    public String toString() {
        String str = "{ weight='" + this.getWeight() + "', price='" + this.price + "'}";
        return str;
    }
        /* 
        Compare cars based on their price, 
        cheaper has lower priority.
        same return 0
        more expensive has higher priority
    */
    @Override
    public int compareTo( Car c) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        if (this.price < c.getPrice()) return BEFORE;
        else if (this.price > c.getPrice()) return AFTER;
        else return EQUAL;
    }
    
        /*
        compare cars based on their price - see JUnit test
        
        if price is the same, compare 
            based on weight - as implemented by the superclass
    */
    @Override
    public boolean isBetter(Object o) {
      if (this.price > ((Car) o).getPrice()) return true;
      else if (this.price < ((Car) o).getPrice()) return false;
      else {
    	  if (((Vehicle) o).getWeight() > this.getWeight()) return true;
    	  else return false;
      }
    }
    
        /*
        compare cars based on their price
        if price is the same, compare 
            based on weight - as implemented by the superclass
    */
    @Override
    public boolean isWorst(Object o) {
    	
	      if (this.price < ((Car) o).getPrice()) return true;
	      else if (this.price > ((Car) o).getPrice()) return false;
	      else {
	    	  if (((Vehicle) o).getWeight() < this.getWeight()) return true;
	    	  else return false;
	      }
	    
    }
    
    // need a license to drive
    //FIXME
    @Override
    public boolean needLicense() {
        return true;
    }
    
}