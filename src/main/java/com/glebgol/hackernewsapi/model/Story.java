package com.glebgol.hackernewsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {
    private String authorName;
    private int score;
    private LocalDateTime date;
    private String storyUrl;
    private String title;
    private int commentsCount;
    private List<Comment> comments;
}
