package com.omdbaoi.bdd.test.runners;

import io.cucumber.testng.CucumberOptions;
import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(glue = {"com.omdbaoi.bdd.test.stepdefs"}, plugin = {"html:target/cucumber-reports/cucumber-pretty", "json:target/json-cucumber-reports/default/cukejson.json",
        "testng:target/testng-cucumber-reports/cuketestng.xml"}, features = {"src/test/resources/SearchingFilms.feature"})

public class CucumberTest extends AbstractTestNGCucumberParallelTests {

    private static long duration;

    @BeforeClass
    public static void before() {
        RestAssured.baseURI = "http://www.omdbapi.com/?";
        duration = System.currentTimeMillis();
        System.out.println("Thread Id  | Scenario Num       | Step Count");
    }

    @AfterClass
    public static void after() {
        duration = System.currentTimeMillis() - duration;
        System.out.println("DURATION - " + duration);
    }

}