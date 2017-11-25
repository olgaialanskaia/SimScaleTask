package com.simscale;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.simscale.support.TestBase;
import com.simscale.support.TestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;


public class ProjectTests extends TestBase {

    private String projectNameCleanup;

    @After
    public void cleanup() {
        if (projectNameCleanup != null) {
            given()
                    .auth()
                    .none()
                    .header("authorization", token)
                    .delete("/api/v1/projects/oialanskaia/" + projectNameCleanup.toLowerCase())
                    .then()
                    .statusCode(204);
        }
    }

    @Test
    public void shouldCreateProjectSuccessfully() throws Exception {

        final String projectName = "Project" + Integer.toString((int)(Math. random() * 1000));

        final Map<String, Object> project = TestData.getTestProject(projectName);

        given().auth()
                .none()
                .header("authorization", token)
                .contentType("application/json")
                .accept(ContentType.JSON)
                .and()
                .body(project)
                .when().post("/api/v1/projects/oialanskaia")
                .then()
                .statusCode(201);

        Response response = given()
                .auth()
                .none()
                .header("authorization", token)
                .accept(ContentType.JSON)
                .get("/api/v1/projects?limit=100&order=desc&sortby=project_creationdate");

        projectNameCleanup = projectName; // For deletion
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(response.asString()).getAsJsonArray();

        Boolean found = false;
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement el = jsonArray.get(i);
            if (el.getAsJsonObject().get("projectName").toString().replaceAll("\"", "").equals(projectName)) {
                found = true;
                break;
            }
        }
        assertTrue("Project not found", found);
    }
}
