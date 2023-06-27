package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface HotelScrapper {

    void setUp(String url);

    String getComments(String url) throws JsonProcessingException;

    String getServices(String url) throws JsonProcessingException;

    String getLocation(String url) throws JsonProcessingException;

    String getRating(String url) throws JsonProcessingException;


}

