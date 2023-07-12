package br.com.suggestions.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Suggestions {
    @Getter @Setter
    public List<Cities> suggestions;
}
