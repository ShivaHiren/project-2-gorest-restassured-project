package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    static ValidatableResponse response;


    @Test
    public void verifyUserCreatedSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Jhon");
        userPojo.setEmail( getRandomValue()+"@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization", "Bearer f18701fb30de652b28f69e533949d14bf5a6aa48784ef8a29bf6b3871c99e766")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }
    @Test
    public void verifyUserGetSuccessfully(){
        Response response = given()
                .header("Authorization", "Bearer f18701fb30de652b28f69e533949d14bf5a6aa48784ef8a29bf6b3871c99e766")
                .header("Connection", "keep-alive")
                .when()
                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void verifyUserUpdateSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Jhon."+getRandomValue());
        userPojo.setEmail( getRandomValue()+"@gmail.com");
        userPojo.setGender("male");
        userPojo.setStatus("inactive");
        Response response = given()
                .header("Authorization", "Bearer f18701fb30de652b28f69e533949d14bf5a6aa48784ef8a29bf6b3871c99e766")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .put("/users/11748");
        response.prettyPrint();
        response.then().statusCode(200);
    }
    @Test
    public void VerifyUserDeleteSuccessfully(){
        Response response = given()
                .header("Authorization", "Bearer f18701fb30de652b28f69e533949d14bf5a6aa48784ef8a29bf6b3871c99e766")
                .header("Connection", "keep-alive")
                .when()
                .delete("/users/11748");
        response.prettyPrint();
        response.then().statusCode(204);
    }
}


