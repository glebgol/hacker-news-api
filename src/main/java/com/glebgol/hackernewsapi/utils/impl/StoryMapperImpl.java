package com.glebgol.hackernewsapi.utils.impl;

import com.glebgol.hackernewsapi.dto.StoryDTO;
import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.utils.StoryMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Component
public class StoryMapperImpl implements StoryMapper {
    @Override
    public Story map(StoryDTO storyDTO) {
        String authorName = storyDTO.getBy();
        int score = storyDTO.getScore();
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(storyDTO.getTime()),
                TimeZone.getDefault().toZoneId());
        String storyUrl = storyDTO.getUrl();
        String title = storyDTO.getTitle();
        //int commentsCount = storyDTO.getKids().size();

        return new Story(authorName, score, date, storyUrl, title, 0, null);
    }
}
