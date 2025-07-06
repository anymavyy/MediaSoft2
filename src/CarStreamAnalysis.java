import java.util.*;
import java.util.stream.Collectors;

public class CarStreamAnalysis {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("VIN1", "Tesla", "Model S", 2020, 15000, 80000),
                new Car("VIN2", "Toyota", "Camry", 2019, 45000, 25000),
                new Car("VIN3", "BMW", "X5", 2021, 10000, 70000),
                new Car("VIN4", "Tesla", "Model 3",  2022, 5000, 45000)
        );

        // Вывод исходного списка
        System.out.println("Исходный список машин:");
        cars.forEach(System.out::println);

        // Фильтр по пробегу
        List<Car> filteredByMileage = cars.stream()
                .filter(c -> c.mileage < 50000)
                .toList();

        // Сортировка по цене (по убыванию)
        List<Car> sortedByPrice = filteredByMileage.stream()
                .sorted((c1, c2) -> Double.compare(c2.price, c1.price))
                .toList();

        // Топ-3 дорогие
        System.out.println("\nТоп-3 самые дорогие машины:");
        sortedByPrice.stream()
                .limit(3)
                .forEach(System.out::println);

        // Средний пробег
        double avgMileage = cars.stream()
                .mapToInt(c -> c.mileage)
                .average()
                .orElse(0);
        System.out.println("Средний пробег: " + avgMileage + " км");

        // Группировка по производителю
        Map<String, List<Car>> groupedByManufacturer = cars.stream()
                .collect(Collectors.groupingBy(c -> c.manufacturer));
        System.out.println("\nГруппировка по производителю:");
        groupedByManufacturer.forEach((manufacturer, carList) -> {
            System.out.println(manufacturer + ": " + carList.size() + " машин");
        });
    }
}