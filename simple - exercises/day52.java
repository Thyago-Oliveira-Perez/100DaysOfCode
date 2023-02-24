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

        for (int i = 0 ; i < suspendBlocks.size() ; i ++) {

            char[] line = suspendBlocks.get(i);

            for (int j = 0 ; j < line.length ; j++) {
                if (i+1 < suspendBlocks.size()) {
                    int lastLine = suspendBlocks.size();
                    int auxPosition = 1;
                    if (line[j] == '#' && suspendBlocks.get(lastLine - auxPosition)[j] == '-') {
                        char aux = line[j];
                        line[j] = suspendBlocks.get(lastLine - auxPosition)[j];
                        suspendBlocks.get(lastLine - auxPosition)[j] = aux;
                        auxPosition++;
                    }
                }
            }
        }


        return suspendBlocks;
    }
}
