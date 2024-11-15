import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;

public class AddLabelToIssue {

    public static void main(String[] args) {

        String url = "https://api.github.com/repos/{owner}/{repo}/issues/{issue_number}/labels";



        String owner = "Gaja-Amex";
        String repoName = "RestAssured1";
        int issueNumber = 1;

        JSONArray labels = new JSONArray();
        labels.put("bug");
        labels.put("help wanted");

        Response response = RestAssured.given()
                .header("Authorization", "token " + token)
                .contentType("application/json")
                .pathParam("owner", owner)
                .pathParam("repo", repoName)
                .pathParam("issue_number", issueNumber)
                .body(labels.toString())
                .post(url);


        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Labels Added: " + response.getBody().asString());
    }
}
