package com.glebgol.hackernewsapi.services.impl;

import com.glebgol.hackernewsapi.dto.StoryDTO;
import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.model.StoryForPreview;
import com.glebgol.hackernewsapi.services.StoryIdsService;
import com.glebgol.hackernewsapi.services.StoryService;
import com.glebgol.hackernewsapi.utils.StoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class HackerNewsStoryService implements StoryService {
    private final RestTemplate restTemplate;
    private final StoryIdsService idsService;
    private final StoryMapper storyMapper;

    @Value("${story.for.preview.url}")
    private String storyForPreviewUrl;

    @Value("${story.url}")
    private String storyUrl;

    @Override
    public List<StoryForPreview> getRecentStories(int storiesCount) {
        List<StoryForPreview> recentStories = new ArrayList<>(storiesCount);
        List<Integer> ids = idsService.getRecentStoriesIds(storiesCount);

        ids.forEach((id) -> {
            Optional<StoryForPreview> optionalStory = getStoryForPreviewById(id);
            optionalStory.ifPresent(recentStories::add);
        });
        return recentStories;
    }

    @Override
    public Optional<StoryForPreview> getStoryForPreviewById(int id) {
        StoryDTO storyDTO = restTemplate.getForEntity(storyForPreviewUrl, StoryDTO.class, id).getBody();
        return Optional.ofNullable(storyMapper.mapToPreview(storyDTO));
    }

    @Override
    public Optional<Story> getStoryById(int id) {
        StoryDTO storyDTO = restTemplate.getForEntity(storyUrl, StoryDTO.class, id).getBody();
        return Optional.ofNullable(storyMapper.map(storyDTO));
    }
}
