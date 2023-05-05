package com.glebgol.hackernewsapi.services.impl;

import com.glebgol.hackernewsapi.dto.StoryDTO;
import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.model.StoryForPreview;
import com.glebgol.hackernewsapi.services.StoryMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

@Service
public class StoryMapperImpl implements StoryMapper {
    @Override
    public Story map(StoryDTO storyDTO) {
        int id = storyDTO.getId();
        String authorName = storyDTO.getBy();
        int score = storyDTO.getScore();
        LocalDateTime date = getTime(storyDTO);
        String storyUrl = storyDTO.getUrl();
        String title = storyDTO.getTitle();
        List<Integer> commentIds = storyDTO.getKids();
        int commentsCount = 0;
        if (commentIds != null) {
            commentsCount = commentIds.size();
        }
        // TODO: fetch comments

        return new Story(id, authorName, score, date, storyUrl, title, commentsCount, null);
    }

    private LocalDateTime getTime(StoryDTO storyDTO) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(storyDTO.getTime()),
                TimeZone.getDefault().toZoneId());
    }

    @Override
    public StoryForPreview mapToPreview(StoryDTO storyDTO) {
        int id = storyDTO.getId();
        String authorName = storyDTO.getBy();
        int score = storyDTO.getScore();
        LocalDateTime date = getTime(storyDTO);
        String title = storyDTO.getTitle();

        return new StoryForPreview(id, title, score, authorName, date);
    }
}
