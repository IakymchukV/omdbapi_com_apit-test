package com.omdbapi.api.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@ToString
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class RatingsItem {

    @JsonProperty("Value")
    private String value;

    @JsonProperty("Source")
    private String source;

}