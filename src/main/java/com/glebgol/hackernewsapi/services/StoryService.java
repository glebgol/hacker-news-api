package com.glebgol.hackernewsapi.services;

import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.model.StoryForPreview;

import java.util.List;
import java.util.Optional;

public interface StoryService {
    List<StoryForPreview> getNewStories(int storiesCount);
    Optional<StoryForPreview> getStoryForPreviewById(int id);
    Optional<Story> getStoryById(int id);
}
