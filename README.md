# s3-sprintone-trebullock

# RentalApp

The RentalApp is a Java application that simulates a rental system for vehicles. It allows the user to create and calculate the cost of renting different types of vehicles, such as cars, trucks, and bicycles.

## Getting Started

To run the RentalApp, follow these steps:

1. Ensure you have Java installed on your system.
2. Clone the repository or download the source code files.
3. Open the project in your preferred Java development environment (e.g., Eclipse, IntelliJ IDEA).
4. Build and compile the project.
5. Run the `RentalApp` class as the main entry point.

## Usage

Upon running the `RentalApp`, it will generate a list of 6 rented vehicles with random parameters. The program will calculate and display the cost for each rented vehicle based on its specific type and rental details.

## Classes

The RentalApp consists of the following classes:

- `RentedVehicle`: Represents a rented vehicle and contains the base fee information.
- `FuelVehicle`: Extends `RentedVehicle` and represents a vehicle that uses fuel. It includes the number of kilometers driven and calculates mileage fees.
- `Car`: Extends `FuelVehicle` and represents a car. It includes the number of seats and calculates the rental cost based on mileage fees and the number of seats.
- `Truck`: Extends `FuelVehicle` and represents a truck. It includes the cargo capacity and calculates the rental cost based on mileage fees and the cargo capacity.
- `Bicycle`: Extends `RentedVehicle` and represents a bicycle. It includes the number of rental days and calculates the rental cost based on the base fee and the number of days.

## Customization

You can modify the following parameters to customize the behavior of the RentalApp:

- Number of rented vehicles: Adjust the length of the `rentedVehicles` array in the `main` method to change the number of rented vehicles generated.
- Base fee ranges: Modify the random number generation in the `main` method to adjust the ranges for the base fee values.
- Rental details ranges: Adjust the random number generation for `nbKms`, `nbSeats`, `capacity`, and `nbDays` to change the ranges for the rental details of each vehicle type.

Feel free to explore and modify the code to suit your specific requirements.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

- The RentalApp was developed as a learning project and may contain simplifications or assumptions.
