package com.glebgol.hackernewsapi.services.impl;

import com.glebgol.hackernewsapi.services.StoryIdsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class HackerNewsStoryIdsService implements StoryIdsService {
    private final RestTemplate restTemplate;

    @Value("${recent.story.ids.url}")
    private String uri;

    @Override
    public List<Integer> getRecentStoriesIds(int storiesCount) {
        Integer[] ids = restTemplate.getForEntity(uri, Integer[].class).getBody();
        if (ids == null) {
            log.warn("ids is null!");
            return new ArrayList<>();
        }
        return Arrays.stream(ids)
                .limit(storiesCount)
                .collect(Collectors.toList());
    }
}
