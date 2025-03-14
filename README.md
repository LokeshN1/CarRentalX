
# CarRentalX

CarRentalX is a console-based **Car Rental Management System** built in Java. It allows users to rent and return cars, manage customer records, and calculate rental costs dynamically. This project demonstrates the use of **OOP principles**, such as encapsulation and polymorphism, and implements **List-based collections** in Java.

## 🚀 Features

- 🏎 **Rent a Car**: Customers can select a car and specify the rental duration.
- 🔄 **Return a Car**: Allows users to return a rented vehicle.
- 📊 **Dynamic Pricing**: Calculates rental costs based on the number of days.
- ✅ **Car Availability Management**: Updates availability status when a car is rented or returned.
- 📋 **Customer Management**: Automatically assigns customer IDs and stores rental records.

## 🛠 Technologies Used

- **Java** (Core Java, Collections, OOP)
- **Scanner** (for user input handling)

## 📌 Project Structure

```
CarRentalX/
│── Main.java              # Entry point for the program
│── Car.class               # Car class (encapsulates car details & rental price calculation)
│── Customer.class          # Customer class (stores customer info)
│── Rental.class            # Rental class (tracks rental transactions)
│── CarRentalSystem.class   # Core logic for renting/returning cars
│── README.md              # Documentation
```

## 🎮 How to Run

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/your-username/CarRentalX.git
   cd CarRentalX
   cd src     # Navigate into the src folder where Main.java is located
   ```

2. **Compile the Java Files**:
   ```sh
   javac Main.java
   ```

3. **Run the Program**:
   ```sh
   java Main
   ```

## 📸 Demo

```
===== Car Rental System =====
1. Rent a Car
2. Return a Car
3. Exit
Enter your choice: 1

== Rent a Car ==

Enter your name: Lokesh

Available Cars:
ID     Model     Brand     Price/Day
-------------------------------------
C001   X5       BMW       $200.0
C002   Corolla  Toyota    $55.0
...

Enter the car ID you want to rent: C001
Enter the number of days for rental: 3

Total Price: $600.00

Confirm rental (Y/N): Y

Car rented successfully.
```

