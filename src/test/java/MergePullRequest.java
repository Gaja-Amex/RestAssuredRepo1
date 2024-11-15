import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class MergePullRequest {

    public static void main(String[] args) {
        String url = "https://api.github.com/repos/{owner}/{repo}/pulls/{pull_number}/merge";

        String token = "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";

        String owner = "Gaja-Amex";
        String repoName = "FirstAssignment";
        int pullRequestNumber = 1;

        JSONObject mergeDetails = new JSONObject();
        mergeDetails.put("commit_message", "Merging automated pull request");

        Response response = RestAssured.given()
                .header("Authorization", "token " + token)
                .contentType("application/json")
                .pathParam("owner", owner)
                .pathParam("repo", repoName)
                .pathParam("pull_number", pullRequestNumber)
                .body(mergeDetails.toString())
                .put(url);

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Pull Request Merged: " + response.getBody().asString());
    }
}
