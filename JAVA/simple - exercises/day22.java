import java.text.MessageFormat;

public class day22 {

    public static void main(String[] args) {

        System.out.println(MessageFormat.format("{0} soccer fields", Km2ToSoccerField(1034)));
        System.out.println(MessageFormat.format("{0} soccer fields", Km2ToSoccerField(9762)));
        System.out.println(MessageFormat.format("{0} soccer fields", Km2ToSoccerField(7536)));
    }

    public static double Km2ToSoccerField (long km2) {

        int areaSoccer = 105*68;
        double km2InM2 = km2 * 1000;

        //number of soccer fields
        return km2InM2 / areaSoccer;
    }

}
