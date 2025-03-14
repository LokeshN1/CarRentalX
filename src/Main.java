import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Car Class
class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    // Constructor to initialize car details
    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true; // Initially, all cars are available
    }

    public String getCarId() {
        return carId;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    
    // Calculate rental price based on the number of days
    public double calculatePrice(int rentalDays) {
        return rentalDays * basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Mark the car as rented (unavailable)
    public void rent() {
        isAvailable = false;
    }

    // Mark the car as available when returned
    public void returnCar() {
        isAvailable = true;
    }
}

// Customer Class
class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}

// Rental Class (a record of a car being rented)
class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}

//  Car Rental System Class
class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    // Add a new car to the system
    public void addCar(Car car) {
        cars.add(car);
    }

    // Add a new customer to the system
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Add a rental record
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    // Rent a car to a customer
    public void rentCar(Car car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    // Return a rented car
    public void returnCar(Car car) {
        Rental rentalToRemove = null;

        for (Rental r : rentals) {
            if (r.getCar() == car) {
                rentalToRemove = r;
                break;
            }
        }
        
        if (rentalToRemove != null) {
            car.returnCar();
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("Car was not rented.");
        }
    }

    // Display menu for user interaction
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                // Renting process
                System.out.println("\n== Rent a Car ==\n");
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();

                // Display available cars
                System.out.println("\nAvailable Cars:");
                System.out.println("ID\tModel\tBrand\tPrice/Day"); // Header for better readability
                System.out.println("--------------------------------");
                
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + "\t" + car.getModel() + "\t" + car.getBrand() + "\t$" + car.calculatePrice(1));
                    }
                }
                
                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = scanner.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine(); 

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.printf("\nTotal Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent.");
                }
            } else if (choice == 2) {
                // Returning process
                System.out.println("\n== Return a Car ==\n");
                System.out.print("Enter the car ID you want to return: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    returnCar(carToReturn);
                    System.out.println("Car returned successfully.");
                } else {
                    System.out.println("Invalid car ID or car is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Car Rental System!");
    }
}

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Adding cars to the system
        rentalSystem.addCar(new Car("C001", "BMW", "X5", 200.0));
        rentalSystem.addCar(new Car("C002", "Toyota", "Corolla", 55.0));
        rentalSystem.addCar(new Car("C003", "Audi", "Q7", 180.0));
        rentalSystem.addCar(new Car("C004", "Ford", "Mustang", 120.0));
        rentalSystem.addCar(new Car("C005", "Nissan", "GTR", 250.0));

        rentalSystem.menu();
    }
}
