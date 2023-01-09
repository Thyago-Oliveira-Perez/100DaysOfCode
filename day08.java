import java.text.MessageFormat;
import java.util.*;

public class day08 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Type the digits: ");
        String userInput = scan.nextLine();

        System.out.print(Combinations(userInput));
    }

    public static String Combinations(String userInput){

        final String failMessage = "Invalid character.";

        if(userInput.isBlank() || userInput.isEmpty()) return userInput;

        try{
            Integer.parseInt(userInput);

            if(userInput.contains("1")) return failMessage;

            List<String> Combinations = new ArrayList<>();
            ArrayList<PhoneKey> selectedPhoneKeys = new ArrayList<>();

            ArrayList<PhoneKey> phoneKeys = new ArrayList<>(){
                {
                    add(new PhoneKey('2', new String[]{"a", "b", "c"}));
                    add(new PhoneKey('3', new String[]{"d", "e", "f"}));
                    add(new PhoneKey('4', new String[]{"g", "h", "i"}));
                    add(new PhoneKey('5', new String[]{"j", "k", "l"}));
                    add(new PhoneKey('6', new String[]{"m", "n", "o"}));
                    add(new PhoneKey('7', new String[]{"p", "q", "r", "s"}));
                    add(new PhoneKey('8', new String[]{"t", "u", "v"}));
                    add(new PhoneKey('9', new String[]{"w", "x", "y", "z"}));
                }
            };

            for(char number: userInput.toCharArray()){
                if(phoneKeys.stream().anyMatch(e -> e.key == number)) {
                    selectedPhoneKeys.add(phoneKeys.stream().filter(e -> e.key == number).findFirst().get());
                }
            }

            if(selectedPhoneKeys.size() == 1) return Arrays.toString(selectedPhoneKeys.get(0).values);

            for(int i = 0; i < selectedPhoneKeys.size(); i++){

                for(int ii = 0; ii < selectedPhoneKeys.get(i).values.length; ii++){

                    if((i+1) < selectedPhoneKeys.size()){

                        for(int o = 0; o < selectedPhoneKeys.get(i+1).values.length; o++){

                            String combination;

                            combination = MessageFormat.format("{0}{1}", selectedPhoneKeys.get(i).values[ii], selectedPhoneKeys.get(i+1).values[o]);
                            Combinations.add(combination);
                        }
                    }
                }
            }

            return Combinations.toString();
        }catch (Exception e){
            return failMessage;
        }
    }

    public static class PhoneKey{

        private final char key;
        private final String[] values;

        public PhoneKey(char key, String[] values) {
            this.key = key;
            this.values = values;
        }

        @Override
        public String toString() {
            return "PhoneKey{" +
                    "key='" + key + '\'' +
                    ", values=" + Arrays.toString(values) +
                    '}';
        }
    }
}
