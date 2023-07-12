package br.com.suggestions.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Cities {
    @Getter @Setter
    public String name;
    @Getter @Setter
    public String latitude;
    @Getter @Setter
    public String longitude;
    @Getter @Setter
    public String score;
}
