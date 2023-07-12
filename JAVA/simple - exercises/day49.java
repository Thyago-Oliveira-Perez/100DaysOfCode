import java.util.ArrayList;
import java.util.List;

public class day49 {

    public static void main(String[] args) {

        List<int[]> possiblePool = new ArrayList<>(){{
            add(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            add(new int[]{0, 0, 1, 1, 1, 0, 0, 0});
            add(new int[]{0, 1, 1, 1, 1, 1, 0, 0});
            add(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        }};

        List<int[]> possiblePool2 = new ArrayList<>(){{    
            add(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
            add(new int[]{0, 0, 1, 1, 1, 0, 0, 0});
            add(new int[]{0, 1, 1, 1, 1, 1, 0, 0});
            add(new int[]{0, 0, 1, 1, 1, 0, 0, 0});        
        }};

        List<int[]> possiblePool3 = new ArrayList<>(){{
            add(new int[]{0, 0, 0, 0, 0});
            add(new int[]{0, 1, 1, 1, 0});
            add(new int[]{0, 1, 1, 1, 0});
            add(new int[]{0, 0, 0, 0, 0});        
        }};


        System.out.println(IsLegitimate(possiblePool));
        System.out.println(IsLegitimate(possiblePool2));
        System.out.println(IsLegitimate(possiblePool3));
    }

    public static boolean IsLegitimate (List<int[]> pool) {

        for (int i = 0 ; i < pool.size() ; i++) {
            int[] line = pool.get(i);
            for (int k : line) {
                if (i == 0 && k != 0 || i == (pool.size() - 1) && k != 0 ||
                        line[0] != 0 || line[(line.length - 1)] != 0
                ) {
                    return false;
                }
            }
        }

        return true;
    }
}
