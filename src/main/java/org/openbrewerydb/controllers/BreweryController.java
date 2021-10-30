package org.openbrewerydb.controllers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.openbrewerydb.constants.Enums;
import org.openbrewerydb.models.BreweryModel;
import org.openbrewerydb.utils.ConfigManager;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.openbrewerydb.constants.EndPoints.*;

public class BreweryController {

    private static final String BASE_URL = "https://api.openbrewerydb.org/";
    //private static final String BASE_URL = ConfigManager.getInstance().getString("base_Url");

    private RequestSpecification requestSpecification;

    public BreweryController() {
        // RestAssured.baseURI = BASE_URL;
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
        new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();
    }

    public BreweryModel getBrewery(String breweryId) {
        return given(requestSpecification)
                .get(GET_BREWER_BY_ID + breweryId)
                .then()
                .statusCode(200)
                .and()
                .assertThat().body("id", equalTo(breweryId))
                .and()
                .log().all()
                .extract().response().as(BreweryModel.class);
    }

    public BreweryModel[] getBreweries() {
        return given(requestSpecification)
                .get(GET_BREWERIES)
                .then()
                .statusCode(200)
                .and()
                .extract().response().as(BreweryModel[].class);
    }

    public BreweryModel[] getBreweriesFiltred (Enums.FilterOption key, String param) {
        return given(requestSpecification )
                .queryParam(key.toString().toLowerCase(), param)
                .get(GET_BREWERIES)
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response().as(BreweryModel[].class);
    }

    public BreweryModel[] getSearchBreweries (Enums.FilterOption key, String searchPhrase) {
        return given(requestSpecification )
                .queryParam(key.toString().toLowerCase(), searchPhrase)
                .get(GET_SEARCH_BREWERIES)
                .then()
                .statusCode(200)
                .assertThat().body("id", containsStringIgnoringCase(searchPhrase))
                .and()
                .log().all()
                .extract().response().as(BreweryModel[].class);
    }

}
