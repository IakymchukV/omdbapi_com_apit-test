package com.omdbapi.tests;

import com.omdbapi.api.payloads.SearchPayload;
import com.omdbapi.api.services.SearchApiService;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


public class SearchTest extends BaseTest {

    private static final SearchApiService searchApiService = new SearchApiService();

    @Test
    public void testSearchFilmNameOnly() {
        SearchPayload searchPayload = new SearchPayload();
        searchApiService.searchFilm(searchPayload.title("Iron Man"))
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"));
    }

    @Test
    public void testSearchFilmNameYear() {
        SearchPayload searchPayload = new SearchPayload();
        searchApiService.searchFilm(searchPayload.title("The Lord of the Rings ").year("1978"))
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"));
    }

    @Test
    public void testSearchFilmFillAllFields() {
        SearchPayload searchPayload = new SearchPayload();
        searchApiService.searchFilm(searchPayload.title("Woman").year( "2000").plot( "Short").response( "JSON"))
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"));
    }

    @Test
    public void testSearchFilmEmptyName() {
        SearchPayload searchPayload = new SearchPayload();

        searchApiService.searchFilm(searchPayload.title("Woman").year( "2000").plot( "Short").response( "JSON"))
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", is("False"));
    }

    @Test
    public void testSerchReturnXml() {
        SearchPayload searchPayload = new SearchPayload();
        searchApiService.searchFilm(searchPayload.title("Woman").year( "2000").plot( "Short").response( "XML"))
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", not("False"))
                .header("Content-Type", is("text/xml; charset=utf-8"));
    }

    @Test
    public void testSearchInvalidYear() {
        SearchPayload searchPayload = new SearchPayload();
        searchApiService.searchFilm(searchPayload.title("Woman").year( "-2034").plot( "Short").response( "JSON"))
                .get().then().log().all()
                .assertThat()
                .statusCode(200)
                .body("Response", is("False"));
    }
}
