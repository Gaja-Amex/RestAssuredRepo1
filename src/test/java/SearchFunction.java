import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class SearchFunction {
    @Test
    public void testSearchRepositories() {

        RestAssured.baseURI = "https://api.github.com";


        String searchQuery = "RestAssuredRepo1";


        String endpoint = "/search/repositories?q=" + searchQuery;


        String githubToken = "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"; // Replace with your GitHub Token


        Response response = given()
                .header("Authorization", "token " + githubToken) // Optional if using authentication
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();


        System.out.println("Response Body: " + response.asString());


        response.jsonPath().getList("items.name").forEach(name -> {
            System.out.println("Repository Name: " + name);
        });


        assertThat(response.jsonPath().getList("items"), not(empty()));
    }
}
