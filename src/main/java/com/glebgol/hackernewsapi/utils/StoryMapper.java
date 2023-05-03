package com.glebgol.hackernewsapi.utils;

import com.glebgol.hackernewsapi.dto.StoryDTO;
import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.model.StoryForPreview;

public interface StoryMapper {
    Story map(StoryDTO storyDTO);
    StoryForPreview mapToPreview(StoryDTO storyDTO);
}
