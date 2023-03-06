import java.util.ArrayList;
import java.util.List;

public class day63 {

    public static void main(String[] args) {
        System.out.println(RabbitProblem(2, 4, 1000000000L));
        System.out.println(RabbitProblem(2, 4, 15000000000L));
    }

    public static int RabbitProblem (int male, int female, long rabbitsAlive) {

        /*
         * every month 14 offspring - 5 males and 9 females
         * a female became fertile at the age of 4 months
         * a rabbit die at the age of 8 years (96 months)
         */
        final int MAX_AGE = 96;
        int monthsToWorldDomination = 0;
        long totalOfRabbits = 0;

        List<Long[]> rabbits = new ArrayList<>(MAX_AGE);
        for (int i = 0 ; i < 96 ; i++) {
            rabbits.add(new Long[]{0L,0L});
        }

        rabbits.set(2, new Long[]{(long)male, (long)female});

        while (totalOfRabbits < rabbitsAlive) {

            int offSprint = 0;

            for (int i = 4 ; i < rabbits.size() ; i++) {
                offSprint += rabbits.get(i)[1];
            }

            rabbits.add(0, new Long[]{offSprint * 5L, offSprint * 9L});
            rabbits.remove(95);

            totalOfRabbits = TotalOfRabbits(rabbits);
            monthsToWorldDomination++;
        }
        return monthsToWorldDomination;
    }

    public static long TotalOfRabbits (List<Long[]> rabbits) {
        long total = 0;

        for (Long[] couple : rabbits) {
            total += couple[0] + couple[1];
        }

        return total;
    }
}