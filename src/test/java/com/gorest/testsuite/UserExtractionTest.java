package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {

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

    // 1)Extract the All Ids
    @Test
    public void test001() {
        List<Integer> listOfproducts = response.extract().path("id");
        System.out.println("List of products are : " + listOfproducts);


    }

    @Test
    public void test002() {
        List<Integer> listOfnames = response.extract().path("name");
        System.out.println("List of products are : " + listOfnames);


    }

    @Test
    public void test003() {
        String Name = response.extract().path("[4].name");
        System.out.println("List of products are : " + Name);

    }

    @Test
    public void test004(){
        List<String>  inActive = response.extract().path("findAll{it.status=='inactive'}.name");
        System.out.println("Name of inactive "+inActive);
    }
    //Extract the gender of all the object whose status = active
    @Test
    public void test005(){
        List<?> listActive = response.extract().path("findAll{it.status=='active'}.gender");
        System.out.println("Name of inactive "+listActive);
    }
    //Print the names of the object whose gender = female
    @Test
    public void test006(){

        List<?> listAll = response.extract().path("findAll{it.gender=='female'}.name");
        System.out.println("Name of femal "+listAll);
    }
@Test
public void test007(){

    List<String>  inActive = response.extract().path("findAll{it.status=='inactive'}.email");
    System.out.println("Name of femal "+inActive);
}

    @Test
    public void test008(){

        List<String>  id = response.extract().path("findAll{it.gender='male'}.id");
        System.out.println("Name of femal "+id);
    }

@Test

public void test009(){

    List<String>  status = response.extract().path("status");
    System.out.println("Name of femal "+status);
}
    //Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test10(){
        List<?> listAllEmail = response.extract().path("findAll{it.name=='Aashritha Bhattathiri'}.email");
        System.out.println("all email "+listAllEmail);

    }
    //Get gender of id = 5471
    @Test
    public void test11(){
        List<?> listAllGender = response.extract().path("findAll{it.id==5310}.gender");
        System.out.println("all gender "+listAllGender);
    }

}




