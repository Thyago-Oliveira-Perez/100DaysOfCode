import java.text.MessageFormat;
import java.util.Scanner;

public class day01 {
    public static void main(String[] args) {

        String skipPhrase = "skip";
        boolean skip = false;

        Scanner scan = new Scanner(System.in);

        while(!skip){

            System.out.println("To skip type: 'skip'");
            System.out.print("Type your age in years:");
            String userInput = scan.nextLine();

            if(userInput.equals(skipPhrase)){
                System.out.println("Thank you!");
                skip = true;
            }else{
                try{
                    int age = convertYearsToDays(Integer.parseInt(userInput));
                    String message = MessageFormat.format("Your age in days is {0} days", age);
                    System.out.println(message);
                }catch(Exception e){
                    System.out.println("Only number. Try again.");
                }
            }
        }
    }

    public static int convertYearsToDays(int userAgeInYears){
        int year = 365;
        return userAgeInYears * year;
    }

}
