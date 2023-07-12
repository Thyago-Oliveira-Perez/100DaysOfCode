public class day57 {

    public static void main(String[] args) {
        System.out.println(Sigilize("i am healthy"));
        System.out.println(Sigilize("I FOUND MY SOULMATE"));
        System.out.println(Sigilize("I have a job I enjoy and it pays well"));
    }

    public static String Sigilize (String message) {

        char space = ' ';
        final String vowels = "AEIOU";
        StringBuilder stringAux = new StringBuilder();
        StringBuilder newMessage = new StringBuilder();

        boolean verse = true;
        int i = 0;

        char[] messageArray = message.toUpperCase().toCharArray();

        while (true) {

            if (verse) {
                if (!vowels.contains(String.valueOf(messageArray[i])) && messageArray[i] != space ) {
                    stringAux.append(messageArray[i]);
                }

                i++;

                if (i == messageArray.length) {
                    verse = false;
                    i = stringAux.length();
                }
            } else {

                i--;

                if (i < 0) break;

                if (!newMessage.toString().contains(String.valueOf(stringAux.charAt(i)))) {
                    newMessage.append(stringAux.charAt(i));
                }
            }
        }

        return newMessage.reverse().toString();
    }
}
