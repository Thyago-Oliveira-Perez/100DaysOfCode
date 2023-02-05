import java.text.MessageFormat;

public class day33 {

    public static void main(String[] args) {

        System.out.println(MessageFormat.format("'O S, GOMR YPFSU/' means -> {0}", KeyboardMistake("O S, GOMR YPFSU/")));
    }

    public static String KeyboardMistake (String message) {

        final char[] keyBoardKeys = new char[]{'1','2','3','4','5','6','7','8','9','0','-','=','Q','W','E','R','T','Y','U','I','O','P','[',']','A','S','D','F','G','H','J','K','L',';','"','Z','X','C','V','B','N','M',',', '.', '/'};

        char[] messageArray = message.toCharArray();
        char[] decodedMessage = new char[messageArray.length];

        for (int i = 0 ; i < messageArray.length ; i++) {

            for (int j = 0 ; j < keyBoardKeys.length ; j++) {

                if (messageArray[i] == keyBoardKeys[j]) {
                    decodedMessage[i] = keyBoardKeys[j-1];
                }
            }
        }

        return String.valueOf(decodedMessage);
    }
}
