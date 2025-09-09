import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class login_negative_test {

    String baseUri = "https://bookstore-demo-08zr.onrender.com";
    String path = "/api/auth/login";
    String contentType = "application/json";


    //login superuser wrong account
    @Test
    public void loginSuperuserWrongAccount(){

        String bodyRequest = "{\"userName\":\"random\", \"password\":\"random\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }

    //login superuser wrong username
    @Test
    public void loginSuperuserWrongUsername(){
        String bodyRequest = "{\"userName\":\"superuser50\", \"password\":\"random\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }

    //login superuser wrong password
    @Test
    public void loginSuperuserWrongPassword(){
        String bodyRequest = "{\"userName\":\"random\", \"password\":\"superuser_password\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }



    //login book store management wrong account
    @Test
    public void loginStoreAdminWrongAccount(){
        String bodyRequest = "{\"userName\":\"random\", \"password\":\"random\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }
    //login book store management wrong username
    @Test
    public void loginStoreAdminWrongUsername(){
        String bodyRequest = "{\"userName\":\"storeadmin21\", \"password\":\"random\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }
    //login book store management wrong password
    @Test
    public void loginStoreAdminWrongPassword(){
        String bodyRequest = "{\"userName\":\"random\", \"password\":\"storeadmin_password\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }



    //login user standard wrong account
    @Test
    public void loginUserWrongAccount(){
        String bodyRequest = "{\"userName\":\"random\", \"password\":\"random\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }
    //login user standard wrong username
    @Test
    public void loginUserWrongUsername(){
        String bodyRequest = "{\"userName\":\"random\", \"password\":\"regular_user_password\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }
    //login user standard wrong password
    @Test
    public void loginUserWrongPassword(){
        String bodyRequest = "{\"userName\":\"regularuser\", \"password\":\"random\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", path);
        assertEquals(response.getStatusCode(), 401);
    }
}
