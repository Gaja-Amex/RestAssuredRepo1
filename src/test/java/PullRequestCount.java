import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PullRequestCount {

    private static final String GITHUB_API_URL = "https://api.github.com";
    private static final String GITHUB_TOKEN = "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";

    @Test
    public void testGetPullRequestCount() {
        String owner = "Gaja-Amex";
        String repoName = "RestAssuredRepo5";


        Response response = given()
                .header("Authorization", "Bearer " + GITHUB_TOKEN)
                .when()
                .get(GITHUB_API_URL + "/repos/" + owner + "/" + repoName + "/pulls");


        Assert.assertEquals(response.getStatusCode(), 200, "Failed to fetch pull requests!");


        int pullRequestCount = response.jsonPath().getList("$").size();


        System.out.println("Pull Request Count: " + pullRequestCount);


        Assert.assertTrue(pullRequestCount >= 0, "Invalid pull request count!");


        response.prettyPrint();
    }
}
