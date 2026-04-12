 import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;

public class CrudExample {
    public static void main(String[] args) {
        String baseUrl = "https://jsonplaceholder.typicode.com/posts";
        System.out.print("ashraf ali");

        // GET all posts
        given()
            .when()
            .get(baseUrl)
            .then()
            .statusCode(200)
            .log().body();

        // GET single post
        given()
            .when()
            .get(baseUrl + "/1")
            .then()
            .statusCode(200)
            .log().body();

        // POST - create new post
        Map<String, Object> postData = new HashMap<>();
        postData.put("title", "New Title");
        postData.put("body", "New body content");
        postData.put("userId", 10);

        given()
            .contentType(ContentType.JSON)
            .body(postData)
            .when()
            .post(baseUrl)
            .then()
            .statusCode(201)
            .log().body();

        // PUT - full update of post 1
        Map<String, Object> putData = new HashMap<>();
        putData.put("id", 1);
        putData.put("title", "Updated Title");
        putData.put("body", "Updated body content");
        putData.put("userId", 1);

        given()
            .contentType(ContentType.JSON)
            .body(putData)
            .when()
            .put(baseUrl + "/1")
            .then()
            .statusCode(200)
            .log().body();

        // PATCH - partial update of post 1
        Map<String, Object> patchData = new HashMap<>();
        patchData.put("title", "Patched Title");

        given()
            .contentType(ContentType.JSON)
            .body(patchData)
            .when()
            .patch(baseUrl + "/1")
            .then()
            .statusCode(200)
            .log().body();

        // DELETE post 1
        given()
            .when()
            .delete(baseUrl + "/1")
            .then()
            .statusCode(200)
            .log().all();
    }
}
