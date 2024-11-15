
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CreateIssues {
    @Test
    public void createIssues() {
        given()
                .auth().oauth2("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")
                .body("{ \"title\": \"Issue Title\", \"body\": \"Issue description\" }")
                .when()
                .post("https://api.github.com/repos/Gaja-Amex/FirstAssignment/issues")
                .then()
                .statusCode(201)
                .body("title", equalTo("Issue Title"));
    }

}
