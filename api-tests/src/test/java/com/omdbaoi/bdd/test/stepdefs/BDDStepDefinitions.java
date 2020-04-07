package com.omdbaoi.bdd.test.stepdefs;

import com.omdbapi.api.payloads.SearchPayload;
import com.omdbapi.api.services.SearchApiService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.is;

public class BDDStepDefinitions {
    private static final SearchApiService searchApiService = new SearchApiService();
    SearchPayload searchPayload = new SearchPayload();
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    //Scenario Search film by title
    @Given("User search the new film {string}")
    public void user_search_the_new_film(String filmName) {
        request = searchApiService.searchFilm(searchPayload.title(filmName));
    }

    @When("User receive response according to search")
    public void user_perform_search_only_by_name() {
        response = request.get();

    }

    @Then("User search completed successfully by film name {string}")
    public void user_search_completed_successfully_by_film_name(String expectedFilmName) {
        json = response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Title", is(expectedFilmName))
                .body("Response", is("True"));
    }


    //Scenario2 searching films by Name and Year
    @Given("User search the new film  with name {string} and year {string}")
    public void user_search_the_new_film_with_name_and_year(String filmName, String filmYear) {
        request = searchApiService.searchFilm(searchPayload.title(filmName).year(filmYear));
    }

    @When("User receive response for film name and year")
    public void user_recieve_response_name_year() {
        response = request.get();

    }

    @Then("User search completed successfully by film name {string} and year {string}")
    public void user_search_completed_successfully_by_film_name_and_year(String filmName, String filmYear) {
        json = response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Title", is(filmName))
                .body("Year", is(filmYear))
                .body("Response", is("True"));
    }

    //Scenario3 searching film using all fields
    @Given("User search film using all fields with name {string},year {string}, plot {string}, response {string}")
    public void user_search_film_using_all_fields_with_name_year_plot_response(String filmName, String filmYear, String plotType, String responseType) {
        request = searchApiService.searchFilm(searchPayload.title(filmName).year(filmYear).plot(plotType).response(responseType));
    }

    @When("User receive response for searching film using all fields")
    public void user_recieve_response_for_searching_film_using_all_fields() {
        response = request.get();

    }

    @Then("User search completed successfully by film name {string} ,year {string}, plot {string}, response {string}")
    public void user_search_completed_successfully_by_film_name_year_plot_response(String filmName, String filmYear, String plotType, String responseType) {
        json = response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Title", is(filmName))
                .body("Year", is(filmYear))
                .body("Plot", is(plotType))
                .header("Content-Type", is(responseType));
    }

    //Scenario4 User search film with response type xml
    @Given("User search film with response XML film name {string},year {string}, plot {string}, response {string}")
    public void user_search_film_with_response_XML_film_name_year_plot_respone(String filmName, String filmYear, String plotType, String responseType) {
        request = searchApiService.searchFilm(searchPayload.title(filmName).year(filmYear).plot(plotType).response(responseType));
    }

    @When("User receive response for searching film with xml response")
    public void user_receive_response_for_searching_film_with_xml_response() {
        response = request.get();
    }

    @Then("User search completed successfully with response type {string}")
    public void user_search_completed_successfully_with_response_type(String plotType) {
        json = response.then().log().all()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", is(plotType));
    }

    //Scenario5 User search film with empty title
    @Given("User search the new film  with empty name {string}")
    public void user_search_the_new_film_with_empty_name(String emptyName) {
        request = searchApiService.searchFilm(searchPayload.title(emptyName));
    }

    @When("User receive response with warning")
    public void user_receive_response_with_warning() {
        response = request.get();

    }

    @Then("User see that response {string} with warning {string}")
    public void user_see_that_response_with_warning(String responseValue, String warningMessage) {
        json = response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", is(responseValue))
                .body("Error", is(warningMessage));
    }

    //Scenario6 User search film with invalid name
    @Given("User search the new film  with invalid name {string}")
    public void user_search_the_new_film_with_invalid_name(String emptyName) {
        request = searchApiService.searchFilm(searchPayload.title(emptyName));
    }

    @When("User receive response with valid error message")
    public void user_receive_response_with_valid_error_message() {
        response = request.get();

    }

    @Then("User see that response {string} with error {string}")
    public void user_see_that_response_with_error(String responseValue, String errorMessage) {
        json = response.then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", is(responseValue))
                .body("Error", is(errorMessage));
    }
}
