import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class day61 {

    public static void main(String[] args) {
        System.out.println(WebCrawler("http://example.com", 1));
        System.out.println(WebCrawler("http://example.com", 2));
        System.out.println(WebCrawler("https://www.iana.org/domains/reserved", 1));
    }

    public static List<String> WebCrawler (String initialUrl, int depth) {
        List<String> allUrls = new ArrayList<>();

        if (depth == 1) {
            allUrls.addAll(GetUrls(initialUrl));
        } else {
            List<String> urls = new ArrayList<>(){{
                add(initialUrl);
            }};
            for (int i = 0 ; i < depth ; i++) {
                urls.addAll(GetUrls(urls.get(i)));
            }

            for (String url : urls) {
                if (!allUrls.contains(url) && !url.equals(initialUrl)) {
                    allUrls.add(url);
                }
            }
        }

        return allUrls;
    }

    public static List<String> GetUrls (String initialUrl) {
        List<String> urls = new ArrayList<>();

        try {
            URL url = new URL(initialUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader content = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String contentLine;
            while ((contentLine = content.readLine()) != null) {
                if (contentLine.contains("<a ") && contentLine.contains("href=")) {
                    String link = contentLine.substring(contentLine.indexOf("<a"), (contentLine.indexOf("a>"))).split("\"")[1];
                    urls.add(link);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return urls;
    }
}
