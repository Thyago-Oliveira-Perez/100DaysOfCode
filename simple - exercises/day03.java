import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class day03 {

    public static void main(String[] args) {

        List<String> skewers = Arrays.asList(
                "--oooo-ooo--",
                "--xx--x--xx--",
                "--o---o--oo--",
                "--xx--x--ox--",
                "--xx--x--ox--"
        );

        Skewers(skewers);
    }

    public static void Skewers(List<String> skewers){

        int vegetarianSkewers = 0;
        int nonVegetarianSkewers = 0;

        for(String skewer: skewers){

            char[] skewerArray = skewer.toCharArray();
            boolean isNonVegetarion = false;

            for(char i : skewerArray){
                if(i == 'x') isNonVegetarion = true;
            }

            if(isNonVegetarion) nonVegetarianSkewers += 1; else vegetarianSkewers += 1;
        }

        System.out.println(MessageFormat.format("[{0}], [{1}]", vegetarianSkewers, nonVegetarianSkewers));
    }
}
