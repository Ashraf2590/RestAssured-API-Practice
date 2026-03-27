import static io.restassured.RestAssured.*;

public class DeleteExample {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        given()
            .header("Content-Type", "application/json")
        .when()
            .delete(url)
        .then()
            .statusCode(200)
            .log().all();
    }
}
