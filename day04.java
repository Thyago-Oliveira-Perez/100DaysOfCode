import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day04 {

    public static void main(String[] args) {

        final String errorMessage = "Type only numbers!";
        List<Integer> miles = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print("Type the number of saturdays you want to analyse: ");
            String numberOfSaturdays = scan.next();

            try{
                int saturdays = Integer.parseInt(numberOfSaturdays);

                System.out.println("Type the number of miles you have run in the last saturdays: ");
                for(int i = 0; i < saturdays; i++){
                    try{
                        System.out.print(MessageFormat.format("saturday {0}:", (i+1)));
                        int mile = Integer.parseInt(scan.next());
                        miles.add(mile);
                    }catch (Exception e){
                        i = (i-1);
                        System.out.println(errorMessage);
                    }
                }

                break;

            }catch(Exception e){
                System.out.println(errorMessage);
            }
        }

        System.out.println(MessageFormat.format("Number of progress days: {0}", ProgressDays(miles)));
    }

    public static int ProgressDays(List<Integer> miles){

        int numberOfProgress = 0;

        for(int i = 0; i < miles.size(); i++){
            if((i+1) < miles.size() && miles.get(i) < miles.get(i+1)) numberOfProgress += 1;
        }

        return numberOfProgress;
    }
}
