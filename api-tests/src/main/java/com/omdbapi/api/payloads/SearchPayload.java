package com.omdbapi.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(fluent = true)
public class SearchPayload {

    @JsonProperty("t")
    private String title;

    @JsonProperty("y")
    private String year;

    @JsonProperty("plot")
    private String plot;

    @JsonProperty("r")
    private String response;
}