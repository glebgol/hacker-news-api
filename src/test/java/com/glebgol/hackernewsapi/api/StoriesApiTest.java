package com.glebgol.hackernewsapi.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoriesApiTest {
    private TestRestTemplate testRestTemplate;
    private final static String storiesUrl = "http://localhost:8080/api/v1/newstories";
    private final static String storyUrl = "http://localhost:8080/api/v1/story/";

    @BeforeEach
    public void setUp() {
        testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void testGetPreviewNewsWithNegativeNewsCountExpectBadRequest() {
        int expectedStatusCode = 400;

        ResponseEntity<?> response = testRestTemplate.getForEntity(
                storiesUrl, String.class, Map.of("count", -100));
        int actualStatusCode = response.getStatusCode().value();

        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Test
    public void testGetNewsNonExistentExpectNotFound() {
        int nonExistentId = -100;
        int expectedStatusCode = 404;
        String url = storyUrl + nonExistentId;

        ResponseEntity<?> response = testRestTemplate.getForEntity(url, String.class);
        int actualStatusCode = response.getStatusCode().value();

        assertEquals(expectedStatusCode, actualStatusCode);
    }
}
