import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateRepo {

    public static void main(String[] args) {

        String url = "https://api.github.com/repos/{owner}/{repo}";

        String owner = "Gaja-Amex";
        String repoName = "RestAssuredRepo1";

        Response response = RestAssured.given()
                .pathParam("owner", owner)
                .pathParam("repo", repoName)
                .get(url);

        if (response.getStatusCode() == 404) {
            System.out.println("Repository does not exist.");
        } else {
            System.out.println("Repository exists: " + response.getBody().asString());
        }
    }
}

