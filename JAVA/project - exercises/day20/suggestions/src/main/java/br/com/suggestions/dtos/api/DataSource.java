package br.com.suggestions.dtos.api;

import lombok.Getter;
import lombok.Setter;

public class DataSource {

  @Getter @Setter
  public String sourcename;
  @Getter @Setter
  public String attribution;
  @Getter @Setter
  public String license;
  @Getter @Setter
  public String url;
}
