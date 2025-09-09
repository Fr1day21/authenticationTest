import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class create_negative_test {

    String baseUri = "https://bookstore-demo-08zr.onrender.com";
    String contentType = "application/json";
    String tokenUser = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWd1bGFydXNlciIsImlhdCI6MTc1NzQwNjk2OCwiZXhwIjoxNzU3NDkzMzY4fQ.L9dcC2YJIqqfMNZvGn79-q0OS5-UPOpGXwBXEszxLHg";
    String tokenAdmin = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdG9yZWFkbWluMjEiLCJpYXQiOjE3NTc0MTMxNzIsImV4cCI6MTc1NzQ5OTU3Mn0.jvMQV48c5-6LRkeSeWfdaWDFW943JEufH2rq_KbmjOA";


    //store admin make book store
    @Test
    public void storeAdminMakeBookStore(){

        String bodyRequest = "{\"bookstoreName\":\"Gramedia Depok Baru Lagi\", \"bookstoreAddress\":\"Jl. Raya Margonda Depok 10\", \"bookstorePhoneNo\":\"085767543212\", \"isActive\":\"true\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .header("Authorization", "Bearer " + tokenAdmin)
                .contentType(ContentType.JSON)
                .body(bodyRequest)
                .request("POST", "/api/bookstores/superuser/createBookstore");
        assertEquals(response.getStatusCode(), 401);
    }


    //user make book store
    @Test
    public void userMakeBookStore(){

        String bodyRequest = "{\"bookstoreName\":\"Gramedia Depok Baru Lagi\", \"bookstoreAddress\":\"Jl. Raya Margonda Depok 10\", \"bookstorePhoneNo\":\"085767543212\", \"isActive\":\"true\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .header("Authorization", "Bearer " + tokenUser)
                .contentType(ContentType.JSON)
                .body(bodyRequest)
                .request("POST", "/api/bookstores/superuser/createBookstore");
        assertEquals(response.getStatusCode(), 401);
    }

    //user input book
    @Test
    public void userInputBook(){
        String bodyRequest = "{\"bookIsbn\":\"ISBN-124532323\", \"bookTitle\":\"Android Development for Beginner part 2\", \"bookAuthor\":\"Digital Skola\", \"bookGenre\":\"Programming\"}";

        RestAssured.baseURI = baseUri;

        Response response = RestAssured
                .with()
                .header("Authorization", "Bearer " + tokenUser)
                .contentType(contentType)
                .body(bodyRequest)
                .request("POST", "/api/books/admin/createBook");
        assertEquals(response.getStatusCode(), 401);
    }



}
