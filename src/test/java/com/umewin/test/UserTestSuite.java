package com.umewin.test;

/**
 * Created by murreli on 6/24/16.
 */
import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;
import sun.util.resources.TimeZoneNames_es;

//import java.io.Console;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.URLENC;


public class UserTestSuite {

    /*@Test
    public void register_a_new_user_with_valid_email()  {
        RestAssured.baseURI = "http://test.umewin.com";
        RestAssured.port = 9005;
        String someEmail = "murreli+" + getTimeStamp() +"@umewin.com";
        String name = "carlo";
        String surName = "thom";

        System.out.println(someEmail);

        Response response = given()

                /*  .param("name", name)
                .param("surname", lastName)
                .param("email", email)
                .param("password", DEFAULT_PASSWORD)
                .param("gender", "MALE")
                .when()
                .post(USER_REGISTRATION)
                .andReturn();



                                .param("name", "name"+getTimeStamp())
                                .param("surName","surname"+getTimeStamp())
                                .param("email",someEmail)
                                .param("password","123456")
                                .param("gender", "MALE")
                                .contentType(URLENC)
                            .when()
                                .post("/user/registration")
                            .andReturn();
        int responseCode = response.getStatusCode();
        Assert.assertTrue(responseCode != 201);
       System.out.println(responseCode);
        System.out.println(response.getBody());


    }*/


    @Test
    public void register_an_anonymous_user() {

        RestAssured.baseURI = "http://test.umewin.com:8080";
        RestAssured.port = 8080;

        Response response = given()
                                    .param("gender", "MALE")
                                    .contentType(URLENC)
                                    .headers("X-UMW-USER-TYPE", "ANONYMOUS")
                            .when()
                                    .post("/user/registration")
                            .andReturn();
        int responseCode = response.getStatusCode();
        String email = response.body().toString();
        System.out.println(email);
        Assert.assertTrue(responseCode == 201);

    }




    public int getTimeStamp() {
        Date now = new Date();
        Long longTime = new Long(now.getTime()/1000);
        return (longTime.intValue());
    }

}
