import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class UpdateRepo {

    @Test
    public void updateRepositoryDescription() {

        RestAssured.baseURI = "https://api.github.com";



        String token = "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";

        String owner = "Gaja-Amex";
        String repoName = "FirstAssignment";


        String newDescription = "Updated description using Rest Assured";


        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("description", newDescription);


        Response response = given()
                .header("Authorization", "token " + token) // Use the OAuth2 method to authenticate with the token
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/repos/" + owner + "/" + repoName)
                .then()
                .statusCode(200) // Assert that the response code is 200 (OK)
                .extract()
                .response();


        assertThat(response.jsonPath().getString("description"), is(newDescription));


        System.out.println("Response Body: " + response.getBody().asString());
    }
}
