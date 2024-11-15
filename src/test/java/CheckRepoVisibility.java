
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class CheckRepoVisibility {
    private static final String GITHUB_TOKEN = "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";
    private static final String GITHUB_API_URL = "https://api.github.com";


    @Test
    public void testCheckRepositoryVisibility() {
        String owner = "Gaja-Amex";
        String repoName = "RestAssuredRepo3";


        Response response = given()
                .header("Authorization", "Bearer " + GITHUB_TOKEN)
                .when()
                .get(GITHUB_API_URL + "/repos/" + owner + "/" + repoName);


        Assert.assertEquals(response.getStatusCode(), 200, "Failed to get repository info!");


        String visibility = response.jsonPath().getString("private");
        Assert.assertEquals(visibility, "false", "Repository is not public!");


        response.prettyPrint();
    }
}

