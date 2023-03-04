import java.util.ArrayList;
import java.util.List;

public class day62 {

    public static void main(String[] args) {
        System.out.println(FunnyPlant(21, 1));
        System.out.println(FunnyPlant(200, 15));
        System.out.println(FunnyPlant(50000, 1));
        System.out.println(FunnyPlant(150000, 250));
    }

    public static int FunnyPlant (int numberOfPeople, int originalFruits) {

        List<Integer> allFruits = new ArrayList<>();
        int numbersOfWeeks = 1;

        //add the initials fruits to the total of fruits
        for (int i = 0 ; i < originalFruits ; i++) {
            allFruits.add(0);
        }

        do {
            numbersOfWeeks++;
            PlantFruits(allFruits);
        } while (GetTotalOfFruits(allFruits) < numberOfPeople);


        return numbersOfWeeks;
    }

    public static int GetTotalOfFruits (List<Integer> allFruits) {

        int totalOfFruits = 0;

        for (int fruit : allFruits) {
            totalOfFruits += fruit;
        }

        return totalOfFruits;
    }

    public static void PlantFruits (List<Integer> fruits) {

        for (int i = 0 ; i < fruits.size() ; i++) {
            if (fruits.get(i) != 0) {
                for (int j = 0 ; j < fruits.get(i) ; j++) {
                    fruits.add(0);
                }
            }
            fruits.set(i, fruits.get(i) + 1);
        }
    }
}
