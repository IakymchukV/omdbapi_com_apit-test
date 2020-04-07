package com.omdbapi.tests;

import com.omdbapi.api.services.SearchApiService;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


public class SearchTest extends BaseTest {

    private static final SearchApiService searchApiService = new SearchApiService();

    @Test
    public void testSearchFilmNameOnly() {
        searchApiService.searchFilm("Iron Man")
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"));
    }

    @Test
    public void testSearchFilmNameYear() {
        searchApiService.searchFilm("The Lord of the Rings", "1978")
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"));
    }

    @Test
    public void testSearchFilmFillAllFields() {
        searchApiService.searchFilm("Woman", "2000", "Short", "JSON")
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"));
    }

    @Test
    public void testSearchFilmEmptyName() {
        searchApiService.searchFilm("", "2000")
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", is("False"));
    }

    @Test
    public void testSerchReturnXml() {
        searchApiService.searchFilm("Star Wars", "2000", "Full", "XML")
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"))
                .header("Content-Type", is("text/xml; charset=utf-8"));
    }

    @Test
    public void testSearchInvalidYear() {
        searchApiService.searchFilm("Star Wars", "-123", "bla")
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", is("False"));
    }
}
