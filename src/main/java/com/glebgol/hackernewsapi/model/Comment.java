package com.glebgol.hackernewsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String author;
    private int id;
    private String text;
    private LocalDateTime dateTime;
    private Comment parentComment;
    private List<Comment> comments;
}
