package com.glebgol.hackernewsapi.services;

import java.util.List;

public interface StoryIdsService {
    List<Integer> getRecentStoriesIds(int storiesCount);
}
