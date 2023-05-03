package com.glebgol.hackernewsapi.services;

import com.glebgol.hackernewsapi.model.Story;

import java.util.List;
import java.util.Optional;

public interface StoryService {
    List<Story> getNewStories(int storiesCount);
    Optional<Story> getStoryById(int id);
}
