package com.omdbapi.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        RestAssured.baseURI = "http://www.omdbapi.com/?";
    }
}
