public abstract class Vehicle implements Estimator{
    private double weight;
    
    protected Vehicle(double weight) throws WeightException{
        setWeight(weight);
    }
    
    @Override
    public String toString() {
        return Double.toString(weight);
    }
    
       public void setWeight(double weight) throws WeightException {
         if (weight < 0) {
            String msg = "[ERROR] weight cannot be negative";
            throw new WeightException(msg);
         }
         else this.weight = weight;
    }
    
   public double getWeight() {
        return weight;
    }
        /*
    Vehicle with a lower weight is better
    */
    public boolean isBetter(Object o){
    	if (((Vehicle) o).getWeight() < this.getWeight()) return true;
    	else return false;
    }
    
        /*
    Vehicle with a higher weight is worst
    */
    public boolean isWorst(Object o){    	
    	if (((Vehicle) o).getWeight() > this.getWeight()) return true;
    	else return false;
    }
   
    public abstract boolean needLicense();
}