package com.simscale.support;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static final String URI = "https://staging.simscale.com";
    protected static String token;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = URI;
        Response response =
                given().auth()
                        .preemptive()
                        .basic("oialanskaia", "Freedom79!")
                        .expect()
                        .statusCode(200)
                        .when()
                        .post("/api/v1/auth/");

        token = response.then().contentType(ContentType.JSON).extract().path("token");

    }


}


