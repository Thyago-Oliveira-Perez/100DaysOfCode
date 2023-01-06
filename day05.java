import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class day05 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Type yours socks: ");
        String socks = scan.nextLine();

        System.out.println(SockPairs(socks.toUpperCase().trim()));
    }

    public static int SockPairs(String socks){

        if (socks.isEmpty()) return 0;

        char[] socksArray =  socks.toCharArray();
        List<String> pastSock = new ArrayList<>();
        int numberOfSocks = 0;

        for(int i = 0; i < socksArray.length; i++){

            char sock = socksArray[i];

            for(int ii = (i+1); ii < socksArray.length; ii++){

                if(sock == socksArray[ii] && !pastSock.contains(String.valueOf(sock))) {
                    pastSock.add(String.valueOf(sock));
                    numberOfSocks++;
                }
            }
        }

        return numberOfSocks;
    }
}
