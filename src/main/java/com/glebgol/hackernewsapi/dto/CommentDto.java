package com.glebgol.hackernewsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private String by;
    private int id;
    private List<Integer> kids;
    private int parent;
    private long time;
    private String text;
    private String type;
}
