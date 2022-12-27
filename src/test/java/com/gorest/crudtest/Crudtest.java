package com.gorest.crudtest;

import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Crudtest extends TestBase {

    @Test
    public void verifyUserCreatedSuccessfully(){

        String payLoad="{\n" +
                "   \"email\": \"prime@ulyahoo.co.uk\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"}";
        Response response = given()
                .baseUri("https://gorest.co.in/public/v2/users")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer {{token}}")
                .body(payLoad)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void verifyUserUpdateSuccessfully(){

        String payLoad="{\n" +
                "   \"email\": \"prime@ulyahoo.co.uk\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"}";
        Response response = given()
                .baseUri("https://gorest.co.in/public/v2/users/id")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer {{token}}")
                .body(payLoad)
                .patch();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void delete() {
    /*curl --location -g --request DELETE 'https://gorest.co.in/public/v2/users/id=2730' \
            --header 'Authorization: Bearer {{token}}*/
        Response response = given()
                .baseUri("https://gorest.co.in/public/v2/users/id")
                .header("Content-Type","application/json")
                .header("Authorization"," Bearer {{token}}")
                .pathParam("id",2730)
                .when()
                .delete("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }




}
