import java.text.MessageFormat;

public class day53 {

    public static void main(String[] args) {

        System.out.println(JavelinThrow(36.7,45));
        System.out.println(JavelinThrow(51.3,20));
        System.out.println(JavelinThrow(100.1,89));

    }

    public static String JavelinThrow (double speed, int angle) {

        //Speed is in meters per second m/s
        //Angle is degrees
        //Gravity force equals to 9.81 m/s^2

        double yMax = Math.pow(speed * Math.sin(angle*3.14/180), 2) / (2 * 9.81);
        double xMax = (2 * speed * Math.sin(angle*3.14/180) / 9.81) * (speed * Math.cos(angle * 3.14/180));

        return MessageFormat.format("Ymax={0}m, Xmax={1}m", Math.round(yMax), Math.round(xMax));
    }
}
