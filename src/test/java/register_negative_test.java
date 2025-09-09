import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class register_negative_test {

    String baseUri = "https://bookstore-demo-08zr.onrender.com";
    String path = "/api/auth/signup";
    String contentType = "application/json";


    //register superuser account exist
    @Test
    public void registerSuperUserExist(){

        String requestBody =
                "{ \"username\":\"superuser103\", \"userEmail\":\"superuser103@gmail.com\", \"password\":\"superuser_password\", \"userRoles\": [ \"ROLE_SUPERUSER\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 400);
    }
    //register superuser email exist
    @Test
    public void registerSuperUserEmailExist(){

        String requestBody =
                "{ \"username\":\"superuser200\", \"userEmail\":\"superuser103@gmail.com\", \"password\":\"superuser_password\", \"userRoles\": [ \"ROLE_SUPERUSER\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 400);
    }


    //register store admin account exist
    @Test
    public void registerStoreAdminExist(){

        String requestBody =
                "{ \"username\":\"storeadmin21\", \"userEmail\":\"storeadmin21@gmail.com\", \"password\":\"superuser_password\", \"userRoles\": [ \"ROLE_STORE_ADMIN\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 400);
    }
    //register store admin email exist
    @Test
    public void registerStoreAdminEmailExist(){

        String requestBody =
                "{ \"username\":\"storeadmin200\", \"userEmail\":\"storeadmin21@gmail.com\", \"password\":\"superuser_password\", \"userRoles\": [ \"ROLE_STORE_ADMIN\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 400);
    }



    //register user account exist
    @Test
    public void registerUserExist(){

        String requestBody =
                "{ \"username\":\"regularuser\", \"userEmail\":\"regularuser@gmail.com\", \"password\":\"superuser_password\", \"userRoles\": [ \"ROLE_USER\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 400);
    }
    //register user account email exist
    @Test
    public void registerUserEmailExist(){

        String requestBody =
                "{ \"username\":\"regularuser200\", \"userEmail\":\"regularuser@gmail.com\", \"password\":\"superuser_password\", \"userRoles\": [ \"ROLE_USER\" ] }";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(requestBody)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 400);
    }
}
