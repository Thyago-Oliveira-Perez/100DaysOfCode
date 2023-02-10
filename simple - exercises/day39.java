public class day39 {

    public static void main(String[] args) {
        System.out.println(HowManyGames(20, 3, 6, 80));
    }

    public static int HowManyGames (int normalPrice, int discount, int minimumValuePerGame, int budget) {

        int totalOfGames = 0;

        while (budget >= minimumValuePerGame) {
            budget =  budget - normalPrice;
            normalPrice -= discount;
            totalOfGames++;
        }

        return totalOfGames;
    }
}
