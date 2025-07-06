import java.util.Random;

public class CarPark {

    public static void main(String[] args) {
        int[] carYears = new int[50];
        Random random = new Random();

        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = random.nextInt(2025 - 2000 + 1) + 2000;
        }

        System.out.println("Годы выпуска всех автомобилей:");
        for (int year : carYears) {
            System.out.print(year + " ");
        }
        System.out.println("\n");

        System.out.println("Автомобили, выпущенные после 2015 года:");
        boolean foundCarsAfter2015 = false;
        for (int year : carYears) {
            if (year > 2015) {
                System.out.print(year + " ");
                foundCarsAfter2015 = true;
            }
        }
        if (!foundCarsAfter2015) {
            System.out.println("Нет автомобилей, выпущенных после 2015 года.");
        }
        System.out.println("\n");

        int currentYear = 2025;
        int totalAge = 0;

        for (int year : carYears) {
            totalAge += (currentYear - year);
        }

        double averageAge = (double) totalAge / carYears.length;

        System.out.printf("Средний возраст автомобилей: %.2f лет%n", averageAge);
    }
}