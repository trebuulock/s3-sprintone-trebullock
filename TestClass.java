import java.util.Random;

class RentedVehicle {
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

class FuelVehicle extends RentedVehicle {
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

    public double getMileageFees() {
        if (nbKms < 100) {
            return 0.2 * nbKms;
        } else if (nbKms >= 100 && nbKms <= 400) {
            return 0.3 * nbKms;
        } else {
            double extraKms = nbKms - 400;
            return 0.3 * 400 + 0.5 * extraKms;
        }
    }
}

class Car extends FuelVehicle {
    private int nbSeats;

    public Car(double baseFee, int nbKms, int nbSeats) {
        super(baseFee, nbKms);
        this.nbSeats = nbSeats;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    @Override
    public double getCost() {
        return super.getCost() + getMileageFees() + (nbSeats * getBaseFee());
    }
}

class Truck extends FuelVehicle {
    private int capacity;

    public Truck(double baseFee, int nbKms, int capacity) {
        super(baseFee, nbKms);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public double getCost() {
        return super.getCost() + getMileageFees() + (getBaseFee() * capacity);
    }
}

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
        return super.getCost() * nbDays;
    }
}

public class TestClass {
    public static void main(String[] args) {
        RentedVehicle[] rentedVehicles = new RentedVehicle[6];

        Random random = new Random();
        for (int i = 0; i < rentedVehicles.length; i++) {
            int randomNumber = random.nextInt(3) + 1;

            if (randomNumber == 1) {
                double baseFee = random.nextInt(100) + 1;
                int nbKms = random.nextInt(500) + 1;
                int nbSeats = random.nextInt(5) + 1;
                rentedVehicles[i] = new Car(baseFee, nbKms, nbSeats);
            } else if (randomNumber == 2) {
                double baseFee = random.nextInt(100) + 1;
                int nbKms = random.nextInt(500) + 1;
                int capacity = random.nextInt(5000) + 1;
                rentedVehicles[i] = new Truck(baseFee, nbKms, capacity);
            } else if (randomNumber == 3) {
                double baseFee = random.nextInt(100) + 1;
                int nbDays = random.nextInt(7) + 1;
                rentedVehicles[i] = new Bicycle(baseFee, nbDays);
            }
        }

        // Print the details of each rented vehicle
        printRentedVehiclesDetails(rentedVehicles);
    }

    private static void printRentedVehiclesDetails(RentedVehicle[] rentedVehicles) {
        for (RentedVehicle rentedVehicle : rentedVehicles) {
            if (rentedVehicle instanceof Car) {
                Car car = (Car) rentedVehicle;
                System.out.println("Car - Number of Seats: " + car.getNbSeats() + ", Cost: " + car.getCost());
            } else if (rentedVehicle instanceof Truck) {
                Truck truck = (Truck) rentedVehicle;
                System.out.println("Truck - Capacity: " + truck.getCapacity() + ", Cost: " + truck.getCost());
            } else if (rentedVehicle instanceof Bicycle) {
                Bicycle bicycle = (Bicycle) rentedVehicle;
                System.out.println("Bicycle - Number of Days: " + bicycle.getNbDays() + ", Cost: " + bicycle.getCost());
            }
        }
    }
}

