package com.omdbapi.tests;

import com.omdbapi.api.payloads.RatingsItem;
import com.omdbapi.api.payloads.SearchPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;



public class SearchTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "http://www.omdbapi.com";
    }

    @Test
    public void testSearchFilm(){
            SearchPayload search = new SearchPayload();


            RestAssured
                    .given().contentType(ContentType.JSON).log().all()
                    .body(search)
                    .when()
                    .post()
                    .then().log().all()
                    .assertThat()
                    .statusCode(200)
                    .body("title", not(isEmptyString()));
    }
}
