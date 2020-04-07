package com.omdbapi.api.services;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiService {
    protected RequestSpecification setup(){
        return RestAssured
                .given()
                .param("apikey", "db470342");
    }
}
