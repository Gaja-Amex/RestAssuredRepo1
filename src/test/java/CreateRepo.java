
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

        import java.util.HashMap;
import java.util.Map;

public class CreateRepo {

    @Test
    public void createRepository() {

        RestAssured.baseURI = "https://api.github.com";

        String token = "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"; // Replace with your token


        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "RestAssuredRepo5");
        requestBody.put("description", "A test repository created using Rest Assured");
        requestBody.put("private", false);


        Response response = given()
                .header("Authorization", "token " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/user/repos")
                .then()
                .statusCode(201)
                .extract()
                .response();


        assertThat(response.jsonPath().getString("name"), is("RestAssuredRepo5"));
    }
}
