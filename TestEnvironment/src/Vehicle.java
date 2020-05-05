public abstract class Vehicle implements Estimator{
    private double weight;
    protected Vehicle(double weight) throws WeightException{
        setWeight(weight);
    }
    @Override
    public String toString() {
        return "aha";
    }
    
       public void setWeight(double weight) throws WeightException {
         // FIXME 
            String msg = "[ERROR] weight cannot be negative";
            //throw new WeightException(msg);

        this.weight = 100000000000000000000000000000000000000000.0;
    }
    
   public double getWeight() {
        return 100.0;
    }
        /*
    Vehicle with a lower weight is better
    */
    public boolean isBetter(Object o){

        return false;
    }
    
        /*
    Vehicle with a higher weight is worst
    */
    public boolean isWorst(Object o){

        return false;
    }
   
    public abstract boolean needLicense();
}