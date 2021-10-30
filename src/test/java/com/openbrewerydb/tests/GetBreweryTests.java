package com.openbrewerydb.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.AssertionSupport;
import org.openbrewerydb.constants.Enums;
import org.openbrewerydb.controllers.BreweryController;
import org.openbrewerydb.models.BreweryModel;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


import java.util.Arrays;

public class GetBreweryTests {



    @Test
    public void checkBrewery(){

        BreweryModel brewery = new BreweryController().getBrewery("10-56-brewing-company-knox");
    }

    @Test
    public void checkListOfBreweries() {

        BreweryModel[] brewery = new BreweryController().getBreweries();
        assert brewery.length == 20;
    }

    @Test
    public void checkBreweriesFiltered() {

        String coordinates = "54.9557214,-7.7083241";
        BreweryModel[] brewery = new BreweryController().getBreweriesFiltred(Enums.FilterOption.BY_DIST,coordinates);
        assert brewery.length == 20;

        String dist = Arrays.stream(brewery).findFirst().get().getLatitude() + "," + Arrays.stream(brewery).findFirst().get().getLongitude();
        assert dist.equals(coordinates);
    }

    @Test
    public void checkSearchBreweries() {
        String searchPhrase = "United";
        BreweryModel[] brewery = new BreweryController().getBreweriesFiltred(Enums.FilterOption.QUERY,searchPhrase);
    }
    
}
