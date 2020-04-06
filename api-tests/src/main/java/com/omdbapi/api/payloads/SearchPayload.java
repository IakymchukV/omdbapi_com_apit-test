package com.omdbapi.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@ToString
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class SearchPayload {

    @JsonProperty("Metascore")
    private String metascore;

    @JsonProperty("BoxOffice")
    private String boxOffice;

    @JsonProperty("Website")
    private String website;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbVotes")
    private String imdbVotes;

    @JsonProperty("Ratings")
    private List<RatingsItem> ratings;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Production")
    private String production;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("DVD")
    private String dVD;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Writer")
    private String writer;

}