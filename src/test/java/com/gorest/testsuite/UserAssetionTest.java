package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class UserAssetionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIT() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);

    }

   // 1. Verify the if the total record is 20
@Test
    public void test001() {
    response.body("total.size", equalTo(20));


//2. Verify the if the name of id = 5318 is equal to ”Rameshwar Varman”
}
    @Test
    public void test002(){
        response.body("[0].name", equalTo("Rameshwar Varman"));

    }
//3.Check the single ‘Name’ in the Array list (Raj Patil)

    @Test
    public void test003() {
        response.body("name", hasItem("Raj Patil"));
    }
//4.Check the multiple ‘Names’ in the ArrayList (Rameshwar Varman, Raj Patil)

@Test
        public void test004() {
            response.body("name", hasItems("Rameshwar Varman",
                    "Raj Patil"));

        }

//5.Verify the emai of userid = 5321 is equal “adiga_aanjaneya_rep@jast.org

    @Test
    public void test005() {
        response.body("find{it.id == 5314}.email",equalTo("chandak_deshpande@hilpert.biz"));
    }


//6.Verify the status is “Active” of user name is “Goswamee Tandon”

    @Test
    public void test006() {
        response.body("find{it.name == 'Goswamee Tandon'}.status",equalTo("active"));
    }

    //7.Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test007(){
        response.body("find{it.name == 'Nagabhushanam Johar'}.gender",equalTo("male"));

    }



    }

