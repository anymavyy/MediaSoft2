import java.util.*;

class Car implements Comparable<Car> {
    String VIN;
    String model;
    String manufacturer;
    int year;
    int mileage;
    double price;

    public Car(String VIN, String model, String manufacturer, int year, int mileage, double price) {
        this.VIN = VIN;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return VIN.equals(car.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VIN);
    }

    @Override
    public String toString() {
        return "Car{" +
                ", " + VIN + '\'' +
                ", " + manufacturer + '\'' +
                ", " + model + '\'' +
                ", " + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year);
    }
}

public class CarComparison {
    public static void main(String[] args) {
        List<Car> rawCars = Arrays.asList(
                new Car("VIN123", "Toyota Camry", "Toyota", 2019, 45000, 25000),
                new Car("VIN123", "Toyota Camry", "Toyota", 2017, 60000, 18000),
                new Car("VIN456", "BMW X5", "BMW", 2019, 25000, 45000),
                new Car("VIN456", "BMW X5", "BMW", 2020, 20000, 50000),
                new Car("VIN789", "Tesla Model S", "Tesla", 2020, 15000, 80000),
                new Car("VIN789", "Tesla Model S", "Tesla", 2018, 30000, 70000),
                new Car("VIN321", "Mercedes-Benz C-Class", "Mercedes", 2020, 30000, 35000),
                new Car("VIN654", "Audi A4", "Audi", 2018, 50000, 23000),
                new Car("VIN987", "Tesla Cybertruck", "Tesla", 2023, 0, 70000),
                new Car("VIN333", "Toyota Corolla", "Toyota", 2015, 90000, 10000),
                new Car("VIN444", "Tesla Model 3", "Tesla", 2022, 8000, 42000),
                new Car("VIN555", "BMW 3 Series", "BMW", 2019, 35000, 28000),
                new Car("VIN666", "Mercedes-Benz E-Class", "Mercedes", 2021, 15000, 60000)
        );

        System.out.println("Исходный список машин (с дубликатами по VIN):");
        rawCars.forEach(System.out::println);

        Set<Car> cars = new HashSet<>(rawCars);

        System.out.println("\nУникальные машины в HashSet:");
        cars.forEach(System.out::println);

        List<Car> sortedCars = new ArrayList<>(cars);
        sortedCars.sort(Collections.reverseOrder());
        System.out.println("\nОтсортированы по году выпуска:");
        sortedCars.forEach(System.out::println);
    }
}
