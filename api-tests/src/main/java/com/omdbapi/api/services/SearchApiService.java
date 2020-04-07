package com.omdbapi.api.services;

import io.restassured.specification.RequestSpecification;

public class SearchApiService extends ApiService {
    private final String titleJSON = "t";
    private final String yearJSON = "y";
    private final String plotJSON = "plot";
    private final String responseJSON = "r";

    public RequestSpecification searchFilm(String filmName) {
        return setup()
                .param(titleJSON, filmName)
                .param(yearJSON, "")
                .param(plotJSON, "")
                .param(responseJSON, "");
    }

    public RequestSpecification searchFilm(String filmName, String year) {
        return setup()
                .param(titleJSON, filmName)
                .param(yearJSON, year)
                .param(plotJSON, "")
                .param(responseJSON, "");
    }

    public RequestSpecification searchFilm(String filmName, String year, String plot) {
        return setup()
                .param(titleJSON, filmName)
                .param(yearJSON, year)
                .param(plotJSON, plot)
                .param(responseJSON, "");

    }

    public RequestSpecification searchFilm(String filmName, String year, String plot, String response) {
        return setup()
                .param(titleJSON, filmName)
                .param(yearJSON, year)
                .param(plotJSON, plot)
                .param(responseJSON, response);
    }
}
