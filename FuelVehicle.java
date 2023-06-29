public class FuelVehicle extends RentedVehicle{
    public abstract class FuelVehicle extends RentedVehicle {
    private int nbKms;

    public FuelVehicle(double baseFee, int nbKms) {
        super(baseFee);
        this.nbKms = nbKms;
    }

    public int getNbKms() {
        return nbKms;
    }

    public void setNbKms(int nbKms) {
        this.nbKms = nbKms;
    }

   public int getMileageFees() {
    if (nbKms < 100) {
        return (int) (0.2 * nbKms);
    } else if (nbKms >= 100 && nbKms <= 400) {
        return (int) (0.3 * nbKms);
    } else {
        int extraKms = nbKms - 400;
        return (int) (0.3 * 400 + 0.5 * extraKms);
    }
}

}

}
