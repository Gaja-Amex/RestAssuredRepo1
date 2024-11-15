
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRepo {


    private static final String GITHUB_TOKEN = "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";
    private static final String GITHUB_API_URL = "https://api.github.com/repos/{owner}/{repo}";

    @Test
    public void testDeleteRepository() {

        String owner = "Gaja-Amex";
        String repoName = "RestAssuredRepo5";


        String deleteRepoUrl = GITHUB_API_URL.replace("{owner}", owner).replace("{repo}", repoName);


        Response response = given()
                .header("Authorization", "Bearer " + GITHUB_TOKEN)
                .when()
                .delete(deleteRepoUrl);


        Assert.assertEquals(response.getStatusCode(), 204, "Repository deletion failed!");


        response.prettyPrint();
    }
}
