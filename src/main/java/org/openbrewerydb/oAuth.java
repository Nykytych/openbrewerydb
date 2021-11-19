package org.openbrewerydb;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class oAuth {

    public static void main(String[] args) {

       String response = given().queryParam("access_token", "")
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").asString();

        System.out.println(response);

    }



}
