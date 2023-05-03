package com.glebgol.hackernewsapi.utils;

import com.glebgol.hackernewsapi.dto.StoryDTO;
import com.glebgol.hackernewsapi.model.Story;

public interface StoryMapper {
    Story map(StoryDTO storyDTO);
}
