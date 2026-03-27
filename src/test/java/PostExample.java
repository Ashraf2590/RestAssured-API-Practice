import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class PostExample {
    public static void main(String[] args) {

        HashMap<String, String> data = new HashMap<>();
        data.put("title", "Ashraf");
        data.put("body", "My Post Body");
        data.put("userId", "1");

        given()
                .header("Content-Type", "application/json")
                .body(data)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .log().body();
    }
}
