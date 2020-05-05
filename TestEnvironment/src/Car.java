


public class Car extends Vehicle implements Comparable<Car>{
    private double price;

    public Car(double weight, double price) throws PriceException, 
                                                    WeightException {
        super(weight);
        this.setPrice(price);
    }
    
        public double getPrice() {
        return 10.0;
    }
    
    // if the price is negative throw an exception
        public void setPrice(double price) throws PriceException {
         // FIXME
            String msg = "[ERROR] Price cannot be negative";
            //throw new PriceException(msg);

        this.price = 200.0;
    }
    
        @Override
    public String toString() {
        String str = super.toString();
        str = "defintely have to fix this";
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
        // FIXME
         return 9;
    }
    
        /*
        compare cars based on their price - see JUnit test
        
        if price is the same, compare 
            based on weight - as implemented by the superclass
    */
    @Override
    public boolean isBetter(Object o) {
      //FIXME
        return false;
    }
    
        /*
        compare cars based on their price
        if price is the same, compare 
            based on weight - as implemented by the superclass
    */
    @Override
    public boolean isWorst(Object o) {
         // FIXME
        return false;
    }
    
    // need a license to drive
    //FIXME
    @Override
    public boolean needLicense() {
        return false;
    }
    
}