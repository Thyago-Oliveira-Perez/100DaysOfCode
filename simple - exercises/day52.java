import java.util.ArrayList;
import java.util.List;

public class day52 {

    public static void main(String[] args) {

        List<char[]> suspendBlocks = new ArrayList<>(){{
            add(new char[]{'-', '#', '#', '-'});
            add(new char[]{'-', '-', '#', '-'});
            add(new char[]{'-', '-', '-', '-'});
        }};

        List<char[]> suspendBlocks2 = new ArrayList<>(){{
            add(new char[]{'-', '#', '#', '-'});
            add(new char[]{'-', '-', '-', '-'});
            add(new char[]{'-', '-', '-', '-'});
            add(new char[]{'-', '-', '-', '-'});
        }};

        List<char[]> suspendBlocks3 = new ArrayList<>(){{
            add(new char[]{'-', '#', '#', '#', '#', '-'});
            add(new char[]{'#', '-', '-', '#', '#', '-'});
            add(new char[]{'-', '#', '-', '-', '-', '-'});
            add(new char[]{'-', '-', '-', '-', '-', '-'});
        }};

        SwitchGravityOn(suspendBlocks).forEach(e -> System.out.println(String.valueOf(e)));
        System.out.println();
        SwitchGravityOn(suspendBlocks2).forEach(e -> System.out.println(String.valueOf(e)));
        System.out.println();
        SwitchGravityOn(suspendBlocks3).forEach(e -> System.out.println(String.valueOf(e)));
    }

    public static List<char[]> SwitchGravityOn (List<char[]> suspendBlocks) {

        for (int j = 0 ; j < suspendBlocks.size() ; j++) {
            for (int i = 0; i < suspendBlocks.get(0).length ; i++) {

                int p = 1;

                while (suspendBlocks.get(j)[i] != '-' && j+p < suspendBlocks.size()) {
                    char aux = suspendBlocks.get(j)[i];
                    suspendBlocks.get(j)[i] = suspendBlocks.get(j+p)[i];
                    suspendBlocks.get(j+p)[i] = aux;
                    p++;
                }
            }
        }

        return suspendBlocks;
    }
}
