import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

public class UpdateExample {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        // Full update (PUT) - send complete resource
        Map<String, Object> putData = new HashMap<>();
        putData.put("id", 1);
        putData.put("title", "Updated Title");
        putData.put("body", "Updated body content");
        putData.put("userId", 1);

        given()
            .header("Content-Type", "application/json")
            .body(putData)
        .when()
            .put(url)
        .then()
            .statusCode(200)
            .log().body();

        // Partial update (PATCH) - send only changed fields
        Map<String, Object> patchData = new HashMap<>();
        patchData.put("title", "Patched Title");

        given()
            .header("Content-Type", "application/json")
            .body(patchData)
        .when()
            .patch(url)
        .then()
            .statusCode(200)
            .log().body();
    }
}