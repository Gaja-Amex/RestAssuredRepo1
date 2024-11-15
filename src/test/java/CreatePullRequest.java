import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class CreatePullRequest {

    public static void main(String[] args) {
        String url = "https://api.github.com/repos/{owner}/{repo}/pulls";

        String token = "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";

        String owner = "Gaja-Amex";
        String repoName = "MavenFirstAssignment";

        JSONObject prDetails = new JSONObject();
        prDetails.put("title", "Automated Pull Request");
        prDetails.put("head", "feature-branch");
        prDetails.put("base", "main");
        prDetails.put("body", "This pull request was created via REST Assured.");

        Response response = RestAssured.given()
                .header("Authorization", "token " + token)
                .contentType("application/json")
                .pathParam("owner", owner)
                .pathParam("repo", repoName)
                .body(prDetails.toString())
                .post(url);

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Pull Request Created: " + response.getBody().asString());
    }
}
