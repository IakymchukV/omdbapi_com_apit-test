package com.omdbapi.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omdbapi.api.payloads.SearchPayload;
import io.restassured.specification.RequestSpecification;

import java.util.Collections;
import java.util.Map;

public class SearchApiService extends ApiService {

    public RequestSpecification searchFilm(SearchPayload searchPayload) {
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> map = oMapper.convertValue(searchPayload, Map.class);
        map.values().removeAll(Collections.singleton(null));
        return setup()
                .params(map);
    }
}
