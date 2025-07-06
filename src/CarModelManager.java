import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarModelManager {
    public static void main(String[] args) {
        List<String> carModels = new ArrayList<>(Arrays.asList(
                "Toyota Camry","Toyota Camry","BMW X5","BMW X5","Tesla Model S",
                "Tesla Model S","Mercedes-Benz C-Class","Audi A4","Tesla Cybertruck"
        ));
        System.out.println("Исходный список автомобилей" + "\n" + carModels + "\n");

        // Убираем дубликаты
        Set<String> uniqueModelsSet = new HashSet<>(carModels);
        List<String> uniqueModelsList = new ArrayList<>(uniqueModelsSet);

        // Сортируем в обратном порядке
        uniqueModelsList.sort(Collections.reverseOrder());
        System.out.println("Уникальные автомобили, обратная сортировка" + "\n" + uniqueModelsList + "\n");
        // Сохраняем в Set
        Set<String> finalUniqueSortedSet = new HashSet<>(uniqueModelsList);
        System.out.println("Уникальные модели, сохраненные в Set" + "\n" + finalUniqueSortedSet + "\n");

        // Если модель содержит слово "Tesla", заменить её на "ELECTRO_CAR".
        List<String> modifiedModels = new ArrayList<>();
        for (String model : uniqueModelsList) {
            if (model.contains("Tesla")) {
                modifiedModels.add("ELECTRO_CAR");
            } else {
                modifiedModels.add(model);
            }
        }
        System.out.println("Замена 'Tesla' на 'ELECTRO_CAR'" + "\n" + modifiedModels + "\n");
    }
}
