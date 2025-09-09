import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class login_positive_test {

        String baseUri = "https://bookstore-demo-08zr.onrender.com";

    //login superuser
    @Test
    public void loginSuperUser(){
        String bodyRequest = "{\"userName\":\"superuser50\", \"password\":\"superuser_password\"}";

        RestAssured.baseURI = baseUri;
        Response response = RestAssured
                .with()
                .contentType("application/json")
                .body(bodyRequest)
                .request("POST", "/api/auth/login");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("userName"), "superuser50");
    }

    //login store admin
    @Test
    public void loginStoreAdmin(){
        String bodyRequest = "{\"userName\":\"storeadmin21\", \"password\":\"storeadmin_password\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType("application/json")
                .body(bodyRequest)
                .request("POST", "/api/auth/login");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("userName"), "storeadmin21");
    }

    //login user
    @Test
    public void loginRegularUser(){
        String bodyRequest = "{\"userName\":\"regularuser\", \"password\":\"regular_user_password\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType("application/json")
                .body(bodyRequest)
                .request("POST", "/api/auth/login");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("userName"), "regularuser");
    }
}
