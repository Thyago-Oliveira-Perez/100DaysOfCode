import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day09 {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Only non-negatives!");
        System.out.print("Type the number to represent an elevation map: ");
        String userInput = scan.nextLine();
        char[] userInputArray = userInput.toCharArray();

        for(int i = 0; i < userInputArray.length; i++){
            try{
                String numberString = String.valueOf(userInputArray[i]);
                numbers.add(Integer.parseInt(numberString));
            }catch (Exception e){
                System.out.println("Invalid character!");
                break;
            }
        }

        System.out.println(MessageFormat.format("Water: {0}", RainWater(numbers)));
    }

    public static int RainWater(List<Integer> numbers){

        int waterLevel = 0;
        int biggestNumber = numbers.stream().max(Integer::compare).get();
        int bucket = 0;
        int length = numbers.size();


        for(int h = 0; h < biggestNumber; h++){
            for(int x = 0; x < length; x++){
                if(numbers.get(x) >= h){
                    for(int y = (x+1); y < length; y++){
                        if(numbers.get(y) < h){
                            if((y+1) > length){
                                bucket = 0;
                                break;
                            }else{
                                bucket++;
                            }
                            continue;
                        }else{
                            x = y-1;
                            waterLevel += bucket;
                            bucket = 0;
                            break;
                        }
                    }
                }
            }
        }

        return waterLevel;
    }

}
