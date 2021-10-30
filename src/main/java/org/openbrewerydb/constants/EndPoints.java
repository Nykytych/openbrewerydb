package org.openbrewerydb.constants;

public class EndPoints {

    public static final String GET_BREWERIES = "/breweries";
    public static final String GET_BREWER_BY_ID = "/breweries/";
/*    public static final String GET_BREWERIES_BY_DIST = "/breweries?by_dist=";
    public static final String GET_BREWERIES_BY_NAME = "/breweries?by_name=";
    public static final String GET_BREWERIES_BY_STATE = "/breweries?by_state";
    public static final String GET_BREWERIES_BY_POSTAL = "/breweries?by_postal=";
    public static final String GET_BREWERIES_BY_TYPE = "/breweries?by_type=";*/
    public static final String GET_SEARCH_BREWERIES = "/breweries/search";

    public enum TypeOption {MICRO, NANO, REGIONAL, BREWPUB, LARGE, PLANNING, BAR, CONTRACT, PROPRIETOR, CLOSED}
}
