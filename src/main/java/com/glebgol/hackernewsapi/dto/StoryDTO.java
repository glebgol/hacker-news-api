package com.glebgol.hackernewsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryDTO {
    private String by;
    private int descendants;
    private int id;
    private List<Integer> kids;
    private int score;
    private long time;
    private String title;
    private String type;
    private String url;
}
