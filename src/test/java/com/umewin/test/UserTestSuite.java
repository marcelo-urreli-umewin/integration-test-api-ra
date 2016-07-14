package com.umewin.test;

/**
 * Created by murreli on 6/24/16.
 */
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.URLENC;


public class UserTestSuite {


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
