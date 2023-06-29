public class Bicycle {
class Bicycle extends RentedVehicle {
    private int nbDays;

    public Bicycle(double baseFee, int nbDays) {
        super(baseFee);
        this.nbDays = nbDays;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    @Override
    public double getCost() {
        return super.getBaseFee() * nbDays;
    }
}
 
}
