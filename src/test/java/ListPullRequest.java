import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListPullRequest {

    public static void main(String[] args) {
        String url = "https://api.github.com/repos/{owner}/{repo}/pulls";

        String owner = "Gaja-Amex";
        String repoName = "MavenFirstAssignment";

        Response response = RestAssured.given()
                .pathParam("owner", owner)
                .pathParam("repo", repoName)
                .get(url);

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Pull Requests: " + response.getBody().asString());
    }
}
