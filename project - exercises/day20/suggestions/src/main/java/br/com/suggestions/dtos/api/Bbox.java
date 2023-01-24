package br.com.suggestions.dtos.api;

import lombok.Getter;
import lombok.Setter;

public class Bbox {
  @Getter @Setter
  public String lon1;
  @Getter @Setter
  public String lat1;
  @Getter @Setter
  public String lon2;
  @Getter @Setter
  public String lat2;
}