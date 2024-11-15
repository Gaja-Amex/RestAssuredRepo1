import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetUserDetails {

    @Test
    public void getAuthenticatedUser() {

        RestAssured.baseURI = "https://api.github.com";


        String token = "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"; // Replace with your GitHub Token


        Response response = given()
                .header("Authorization", "token " + token) // Authentication using the token
                .when()
                .get("/user")
                .then()
                .statusCode(200) // Assert that the response code is 200 (OK)
                .extract()
                .response();


        assertThat(response.jsonPath().getString("login"), is("Gaja-Amex"));
    }
}
