public class day66 {

    public static void main(String[] args) {
        System.out.println(ISBNGenerator());
    }

    public static String ISBNGenerator () {

        char[] ISBNCode = new char[13];

        for (int i = 0 ; i < ISBNCode.length ; i++) {

            if (i == 1 || i == 6 || i == 11) {
                ISBNCode[i] = '-';
            } else {
                ISBNCode[i] = Integer.toString((int)(Math.random() * 10)).toCharArray()[0];
            }
        }

        if (day65.ISBNValidator(String.valueOf(ISBNCode))) {
            return String.valueOf(ISBNCode);
        } else {
            return ISBNGenerator();
        }
    }
}
