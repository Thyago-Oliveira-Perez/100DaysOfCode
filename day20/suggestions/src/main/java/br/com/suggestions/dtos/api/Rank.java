package br.com.suggestions.dtos.api;

import lombok.Getter;
import lombok.Setter;

public class Rank {

  @Getter @Setter
  public String importance; 
  @Getter @Setter
  public String confidence;
  @Getter @Setter
  public String confidence_city_level;
  @Getter @Setter
  public String match_type;
}
