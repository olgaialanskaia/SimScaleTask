package com.simscale;

import com.simscale.support.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UserTests extends TestBase {

    @Test
    public void shouldMatchEmailAddressInUserProfile() throws Exception {

        given().auth()
                .none()
                .header("authorization", token)
                .get("/api/v1/users/oialanskaia")
                .then()
                .body("emailAddress", equalTo("ialanskaia@gmail.com"));
    }
}
