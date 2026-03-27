import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetExample {
    public static void main(String[] args) {

        Response res =
                given()
                        .when()
                        .get("https://www.google.com")
                        .then()
                        .statusCode(200)
                        .extract().response();

        System.out.println(res.asPrettyString());
        System.out.println(res.asPrettyString());
    }
}
