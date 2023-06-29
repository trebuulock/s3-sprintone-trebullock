public class RentedVehicle {
    
}
public abstract class RentedVehicle {
    private double baseFee;

    public RentedVehicle(double baseFee) {
        this.baseFee = baseFee;
    }

    public double getCost() {
        return baseFee;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }

}