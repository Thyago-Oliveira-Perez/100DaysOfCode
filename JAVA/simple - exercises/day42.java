public class day42 {

    public static void main(String[] args) {

        System.out.println(MinPages(5, 3));
        System.out.println(MinPages(6, 6));
    }

    public static int MinPages (int numberOfPages, int pageToFind) {

        int numberOfTurns = 0;

        for (int i = 1 ; i <= numberOfPages ; i+=2) {
            if (pageToFind <= i) break;
            numberOfTurns++;
        }

        return numberOfTurns;
    }
}
