package com.openbrewerydb.tests;

import org.openbrewerydb.constants.*;
import org.openbrewerydb.controllers.BreweryController;
import org.openbrewerydb.models.AutocompleteModel;
import org.openbrewerydb.models.BreweryModel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestsGet {

//   @BeforeMethod
//    public  void getListOfBrewery(){
//       brewery = new BreweryController().getBreweries();
//    }

    //First test for selecting single brewery by ID
    @Test(dataProvider = "breweryIds", testName = "Select brewery by Id: ")
    public void checkBreweriesAccessibleById(String id){

        BreweryModel brewery = new BreweryController().getBrewery(id);
        assert brewery.getId().equals(id);
    }

    //Second test checking full list of available breweries
    @Test
    public void checkAllBreweriesReturns() {

        BreweryModel[] brewery = new BreweryController().getAllBreweries();
        assert brewery.length == 20;
    }

    //Third test verify filter parameter
    @Test(dataProvider = "queryParams")
    public void checkBreweriesCanBeFiltered(String params, String value) {
        String res;
        BreweryModel[] brewery = new BreweryController().getBreweriesFiltred(params, value);

        switch (params) {
            case "by_dist": {
                res = Arrays.stream(brewery).findFirst().get().getLatitude() + "," + Arrays.stream(brewery).findFirst().get().getLongitude();
                assert res.equals(value);
                break;
            }
            case "by_name":{
                res = Arrays.stream(brewery).findFirst().get().getName();
                assert res.toLowerCase().contains(value);
                break;
            }
            case "by_city":{
                res = Arrays.stream(brewery).findFirst().get().getCity();
                assert res.contains(value);
                break;
            }
            case "by_postal":{
                res = Arrays.stream(brewery).findFirst().get().getPostalCode();
                assert res.contains(value);
                break;
            }
            case "by_type":{
                res = Arrays.stream(brewery).findFirst().get().getBreweryType();
                assert res.contains(value);
                break;
            }
        }

    }

    //Forth test verify search functionality
    @Test
    public void checkSearchBreweries() {
        String searchPhrase = "United";

        BreweryModel[] breweries = new BreweryController().getSearchBreweries(QueryParams.QUERY.getParam(),searchPhrase);

    Assert.assertTrue(Arrays.stream(breweries)
            .allMatch(brew -> brew.getName().contains(searchPhrase))
    );
    }

    //Fifth test check autocomplete functionality
    @Test
    public void checkAutocompleteBreweries() {
        String searchPhrase = "dog";

        AutocompleteModel[] breweries = new BreweryController().autocomplete(QueryParams.QUERY.getParam(),searchPhrase);

        Assert.assertTrue(Arrays.stream(breweries)
                .allMatch(brew -> brew.getId().contains(searchPhrase))
        );
    }

    // DataProvider for checkBreweriesAccessibleById test. Currently contains not full list of IDs(example)
    @DataProvider(name="breweryIds")

    public Object[][] dataProviderMethod() {

        return new Object[][] { { "10-56-brewing-company-knox"}, { "10-barrel-brewing-co-bend-1"}, {"10-barrel-brewing-co-bend-2"},
                                { "10-barrel-brewing-co-bend-pub-bend"},  {"10-barrel-brewing-co-denver-denver"},
                                { "10-barrel-brewing-co-portland"}, { "10-barrel-brewing-co-san-diego"}, {"10-torr-distilling-and-brewing-reno"},
                                { "101-brewery-quilcene"}, { "101-north-brewing-company-petaluma"}};
    }

    // DataProvider for checkBreweriesCanBeFiltered test
    @DataProvider(name="queryParams")

    public Object[][] dataProviderQueryParams() {

        return new Object[][] { {QueryParams.BY_DIST.getParam() , "54.9557214,-7.7083241"}, {QueryParams.BY_CITY.getParam() , "Portland"},
                {QueryParams.BY_NAME.getParam(), "cooper"}, {QueryParams.BY_POSTAL.getParam(), "1603"}, {QueryParams.BY_TYPE.getParam(), "micro"}};

    }

}
