package meallab.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import meallab.exceptions.MealAPIException;
import meallab.model.Meals;

public class MealDBService {
    private final String API_URL;
    private final String API_KEY;

    public MealDBService(String API_URL, String API_KEY) {
        this.API_URL = API_URL;
        this.API_KEY = API_KEY;
    }

    // Private helper method to get API data
    private Meals getAPIData(String apiFunction, String parameter) throws MealAPIException {
        try {
            String path = String.format("/api/json/v1/%s/%s.php", API_KEY, apiFunction);
            
            // Build URL: https://www.themealdb.com/api/json/v1/1/search.php?s=parameter
            final URIBuilder uriBuilder = new URIBuilder(API_URL)
                .setPath(path);

            //parameters addition 
            if (parameter != null && !parameter.isBlank()) {
                switch (apiFunction) {
                    case "search": //parameter according to API type
                        uriBuilder.addParameter("s", parameter);
                        break;
                    case "lookup": //parameter according to API type
                        uriBuilder.addParameter("i", parameter);
                        break;
                }
            }

            final URI uri = uriBuilder.build();
            final HttpGet getRequest = new HttpGet(uri);
            
            String jsonResponse;

            try (CloseableHttpClient httpclient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpclient.execute(getRequest)) {

                final HttpEntity entity = response.getEntity();
                final ObjectMapper mapper = new ObjectMapper();

               jsonResponse = EntityUtils.toString(entity);

                // Check for HTTP errors
                if (response.getCode() != HttpStatus.SC_OK) {
                    throw new MealAPIException("Error occurred on API call: HTTP " + response.getCode());
                }

                return mapper.readValue(jsonResponse,Meals.class);
            } catch (IOException | org.apache.hc.core5.http.ParseException e) {
                throw new MealAPIException("Error requesting data from the TheMealDB API.", e);
            }
        } catch (URISyntaxException e) {
            throw new MealAPIException("Unable to create request URI.", e);
        }
    }

    // Get meals by name
    // URL: https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata
    public Meals searchMealByName(String mealName) throws MealAPIException {
        return getAPIData("search", mealName); //use get according to the API
    }

    // Get meal by ID
    // URL: https://www.themealdb.com/api/json/v1/1/lookup.php?i=52772
    public Meals searchMealById(String mealId) throws MealAPIException {
        return getAPIData("lookup", mealId); //use get according to the API
    }

    // Get random meal
    // URL: https://www.themealdb.com/api/json/v1/1/random.php
    public Meals getRandomMeal() throws MealAPIException {
        return getAPIData("random", null); //use get according to the API
    }
}