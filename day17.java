import java.text.MessageFormat;

public class day17 {

    public static void main(String[] args) {

        System.out.println(MessageFormat.format("{0}", PrisonBreak(new int[]{1, 1, 0, 0, 0, 1, 0})));
        System.out.println(MessageFormat.format("{0}", PrisonBreak(new int[]{0, 0, 0, 1, 0})));
        System.out.println(MessageFormat.format("{0}", PrisonBreak(new int[]{0, 0, 0, 0})));
    }

    public static Integer PrisonBreak(int[] cells) {

        if (cells[0] == 0) return 0;

        int freePrisoners = 1;
        int i = 1;

        while (i < cells.length) {

            cells = LockUnlockCells(cells);

            for (int ii = i; ii < cells.length; ii++) {
                if (cells[ii] == 1) {
                    freePrisoners++;
                    i = ii;
                    break;
                }
            }

            i++;
        }

        return freePrisoners;
    }

    public static int[] LockUnlockCells(int[] cells) {

        int[] newCells = new int[cells.length];

        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == 0) {
                newCells[i] = 1;
            } else {
                newCells[i] = 0;
            }
        }

        return newCells;
    }

}
