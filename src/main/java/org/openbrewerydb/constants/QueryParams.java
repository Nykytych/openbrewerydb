package org.openbrewerydb.constants;
public enum QueryParams {

        BY_DIST("by_dist"),
        BY_CITY("by_city"),
        BY_NAME("by_name"),
        BY_STATE("by_name"),
        BY_POSTAL("by_postal"),
        BY_TYPE("by_type"),
        PAGE("page"),
        PER_PAGE("per_page"),
        SORT("sort"),
        QUERY("query");


    private final String param;

    QueryParams(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
