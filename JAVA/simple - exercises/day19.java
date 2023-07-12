import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day19 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Type an Url to be shortener: ");
        String userUrl = scan.nextLine();

        System.out.println(MessageFormat.format("Url shorted: {0}", UrlShortener(userUrl)));
    }

    public static String UrlShortener (String originalUrl) {

        if(originalUrl == null || !IsValidURL(originalUrl)) {
            return MessageFormat.format("A URL não é válida({0})", originalUrl);
        }

        URL url;
        HttpURLConnection conn;
        BufferedReader br = null;
        String line;

        try {
            //this link use php to short an url
            url = new URL("https://is.gd/create.php?format=simple&url=" + originalUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            if ((line = br.readLine()) != null) {
                return line;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static boolean IsValidURL(String URL) {

        final String regexURL = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        Pattern pattern = Pattern.compile(regexURL);
        Matcher matcher = pattern.matcher(URL);

        return matcher.matches();
    }
}
