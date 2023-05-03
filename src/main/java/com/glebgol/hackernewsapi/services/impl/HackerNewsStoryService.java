package com.glebgol.hackernewsapi.services.impl;

import com.glebgol.hackernewsapi.dto.StoryDTO;
import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.model.StoryForPreview;
import com.glebgol.hackernewsapi.services.StoryIdsService;
import com.glebgol.hackernewsapi.services.StoryService;
import com.glebgol.hackernewsapi.utils.StoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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

    @Override
    public List<StoryForPreview> getNewStories(int storiesCount) {
        List<StoryForPreview> newStories = new ArrayList<>(storiesCount);
        List<Integer> ids = idsService.getNewStoriesIds(storiesCount);

        ids.forEach((id) -> {
            Optional<StoryForPreview> optionalStory = getStoryForPreviewById(id);
            optionalStory.ifPresent(newStories::add);
        });
        return newStories;
    }

    @Override
    public Optional<StoryForPreview> getStoryForPreviewById(int id) {
        StoryDTO storyDTO = restTemplate.getForEntity("https://hacker-news.firebaseio.com/v0/item/" + id + ".json",
                StoryDTO.class).getBody();
        log.info(storyDTO);
        return Optional.ofNullable(storyMapper.mapToPreview(storyDTO));
    }

    @Override
    public Optional<Story> getStoryById(int id) {
        StoryDTO storyDTO = restTemplate.getForEntity("https://hacker-news.firebaseio.com/v0/item/" + id + ".json",
                StoryDTO.class).getBody();
        log.info(storyDTO);
        return Optional.ofNullable(storyMapper.map(storyDTO));
    }
}
