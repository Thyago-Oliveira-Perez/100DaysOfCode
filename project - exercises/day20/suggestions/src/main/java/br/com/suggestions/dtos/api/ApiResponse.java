package br.com.suggestions.dtos.api;

import lombok.Getter;
import lombok.Setter;

public class ApiResponse {

    @Getter @Setter
    public DataSource datasource;
    @Getter @Setter
    public String name;
    @Getter @Setter
    public String country;
    @Getter @Setter
    public String country_code;
    @Getter @Setter
    public String state;
    @Getter @Setter
    public String county;
    @Getter @Setter
    public String city;
    @Getter @Setter
    public String postcode;
    @Getter @Setter
    public String suburb;
    @Getter @Setter
    public String quarter;
    @Getter @Setter
    public String street;
    @Getter @Setter
    public String housenumber;
    @Getter @Setter
    public String lon;
    @Getter @Setter
    public String lat;
    @Getter @Setter
    public String state_code;
    @Getter @Setter
    public String district;
    @Getter @Setter
    public String distance;
    @Getter @Setter
    public String formatted;
    @Getter @Setter
    public String address_line1;
    @Getter @Setter
    public String address_line2;
    @Getter @Setter
    public Timezone timezone;
    @Getter @Setter
    public String category;
    @Getter @Setter
    public String result_type;
    @Getter @Setter
    public Rank rank;
    @Getter @Setter
    public String place_id;
    @Getter @Setter
    public Bbox bbox;
}
