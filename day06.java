import java.text.MessageFormat;
import java.util.Scanner;

public class day06 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Type the number: ");
        String userInput = scan.nextLine();

        System.out.println(MessageFormat.format("The next prime is: {0}", NextPrime(Integer.parseInt(userInput))));
    }

    public static int NextPrime(int number){

        while(true){
            int possibleMultiplications = 1;
            for(int i = 2; i <= number ; i++){
                if(number % i == 0) possibleMultiplications++;
            }
            //it means the number is divisible by one and itself only
            if(possibleMultiplications == 2) break;
            possibleMultiplications = 1;
            number++;
        }

        return number;
    }
}
