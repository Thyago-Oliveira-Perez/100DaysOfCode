public class day65 {

    public static void main(String[] args) {
        System.out.println(ISBNValidator("0-7475-3269-9"));
    }

    public static boolean ISBNValidator (String code) {

        int sum = 0;
        char[] codeArray = code.toCharArray();

        int multiply = 10;
        for (char character : codeArray) {

            if (character != '-') {
                sum += multiply * Integer.parseInt(String.valueOf(character));
                multiply--;
            }

        }

        return sum % 11 == 0;
    }
}
