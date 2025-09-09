import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class register_positive_test {


    String baseUri = "https://bookstore-demo-08zr.onrender.com";
    String path = "/api/auth/signup";
    String contentType = "application/json";

    //register superuser
    @Test
    public void registerSuperUser(){

        String requestBody =
                "{ \"username\":\"superuser104\", \"userEmail\":\"superuser105@gmail.com\", \"password\":\"superuser_password\", \"userRoles\": [ \"ROLE_SUPERUSER\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 200);
    }

    //register store admin
    @Test
    public void registerStoreAdmin(){

        String requestBody =
                "{ \"username\":\"storeadmin104\", \"userEmail\":\"storeadmin104@gmail.com\", \"password\":\"storeadmin_password\", \"userRoles\": [ \"ROLE_STORE_ADMIN\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 200);
    }


    //register user
    @Test
    public void registerUser(){

        String requestBody =
                "{ \"username\":\"regularuser104\", \"userEmail\":\"regularuser104@gmail.com\", \"password\":\"regular_user_password\", \"userRoles\": [ \"ROLE_USER\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 200);
    }

}
