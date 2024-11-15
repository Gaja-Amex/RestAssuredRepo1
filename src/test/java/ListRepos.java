import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListRepos {

    @Test
    public void listUserRepositories() {

        RestAssured.baseURI = "https://api.github.com";


        String username = "Gaja-Amex";


        Response response = given()
                .when()
                .get("/users/" + username + "/repos")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Response Body: " + response.jsonPath().getList("name"));

    }
}
