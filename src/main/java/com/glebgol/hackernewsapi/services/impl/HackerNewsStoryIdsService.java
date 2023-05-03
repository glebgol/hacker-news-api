package com.glebgol.hackernewsapi.services.impl;

import com.glebgol.hackernewsapi.services.StoryIdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HackerNewsStoryIdsService implements StoryIdsService {
    private final RestTemplate restTemplate;

    @Override
    public List<Integer> getNewStoriesIds(int storiesCount) {
        Integer[] ids = restTemplate.getForEntity("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty",
                Integer[].class).getBody();
        if (ids == null) {
            return new ArrayList<>();
        }
        return Arrays.stream(ids).limit(storiesCount).collect(Collectors.toList());
    }
}
