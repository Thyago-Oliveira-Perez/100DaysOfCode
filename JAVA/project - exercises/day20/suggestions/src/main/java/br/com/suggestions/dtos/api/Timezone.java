package br.com.suggestions.dtos.api;

import lombok.Getter;
import lombok.Setter;

public class Timezone {

  @Getter @Setter
  public String name_alt;
  @Getter @Setter
  public String name;
  @Getter @Setter
  public String offset_STD;
  @Getter @Setter
  public String offset_STD_seconds;
  @Getter @Setter
  public String offset_DST;
  @Getter @Setter
  public String offset_DST_seconds;
  @Getter @Setter
  public String abbreviation_STD;
  @Getter @Setter
  public String abbreviation_DST ;
}
