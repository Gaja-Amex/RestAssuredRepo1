
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BranchSearch {

    private static final String GITHUB_API_URL = "https://api.github.com";
    private static final String GITHUB_TOKEN = "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"; // Replace with your token

    @Test
    public void testSearchBranchInRepository() {
        String owner = "Gaja-Amex";
        String repoName = "MavenFirstAssignment";
        String branchNameToSearch = "FirstAssignment";


        Response response = given()
                .header("Authorization", "Bearer " + GITHUB_TOKEN)
                .when()
                .get(GITHUB_API_URL + "/repos/" + owner + "/" + repoName + "/branches");


        Assert.assertEquals(response.getStatusCode(), 200, "Failed to fetch branches!");


        boolean isBranchPresent = false;
        for (int i = 0; i < response.jsonPath().getList("$").size(); i++) {
            String branchName = response.jsonPath().getString("[" + i + "].name");
            if (branchName.equalsIgnoreCase(branchNameToSearch)) {
                isBranchPresent = true;
                break;
            }
        }


        Assert.assertTrue(isBranchPresent, "Branch '" + branchNameToSearch + "' was not found!");

    }
}

