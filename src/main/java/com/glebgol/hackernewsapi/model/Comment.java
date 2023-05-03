package com.glebgol.hackernewsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String comment;
    private List<Comment> comments;
}
