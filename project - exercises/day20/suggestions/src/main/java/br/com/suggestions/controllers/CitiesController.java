package br.com.suggestions.controllers;

import br.com.suggestions.dtos.response.Suggestions;
import br.com.suggestions.services.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/suggestions")
public class CitiesController {

    @Autowired
    public CitiesService citiesService;

    @GetMapping
    public ResponseEntity<?> GetCities (@RequestParam(value = "q") String q,
                                                  @RequestParam(value = "latitude", defaultValue = "") String latitude,
                                                  @RequestParam(value = "longitude", defaultValue = "") String longitude
    ){
        return citiesService.GetSuggestions(q, latitude,longitude);
    }
}
