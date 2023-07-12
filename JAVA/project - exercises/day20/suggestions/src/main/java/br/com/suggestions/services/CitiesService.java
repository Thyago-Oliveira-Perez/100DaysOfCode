package br.com.suggestions.services;

import br.com.suggestions.dtos.api.ApiResponse;
import br.com.suggestions.dtos.api.Results;
import br.com.suggestions.dtos.response.Cities;
import br.com.suggestions.dtos.response.Suggestions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitiesService {

    @Value("${apiKey}")
    private String apiKey;

    public ResponseEntity<?> GetSuggestions (String text, String latitude, String longitude) {

        URL url;
        HttpURLConnection conn;
        BufferedReader br = null;
        String line;

        String urlApi = MessageFormat.format("https://api.geoapify.com/v1/geocode/autocomplete?text={0}", text);

        try {

            if (!longitude.isEmpty() && !latitude.isEmpty()) {
                urlApi = MessageFormat.format("{0}.&bias=proximity:{1},{2}&format=json", urlApi, latitude, longitude);
            }


            url = new URL(MessageFormat.format("{0}&apiKey={1}", urlApi, apiKey));

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            if ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            ObjectMapper mapper = new ObjectMapper();
            Results obj = mapper.readValue(line, Results.class);

            return ResponseEntity.ok(FormatToCitiesResponse(obj));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Type latitude and longitude to.");
        }
    }

    private Suggestions FormatToCitiesResponse (Results resultApi) {

        List<String> avaliableCountries = new ArrayList<>(){{
            add("Brazil");
            add("Canada");
            add("USA");
            add("United States");
        }};

        List<Cities> cities = new ArrayList<>();

        Suggestions suggestions = new Suggestions();

        for (ApiResponse result : resultApi.results) {

            if (avaliableCountries.contains(result.country)) {

                Cities city = new Cities(
                    result.country,
                    result.lat,
                    result.lon,
                    result.rank.confidence);

                cities.add(city);
            }
        }

        suggestions.setSuggestions(cities);

        return suggestions;
    }
}
