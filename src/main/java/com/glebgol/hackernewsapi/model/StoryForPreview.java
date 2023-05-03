package com.glebgol.hackernewsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryForPreview {
    private int id;
    private String title;
    private int score;
    private String authorName;
    private LocalDateTime date;
}
