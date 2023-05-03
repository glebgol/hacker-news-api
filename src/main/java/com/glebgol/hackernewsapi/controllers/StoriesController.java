package com.glebgol.hackernewsapi.controllers;

import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoriesController {
    private final StoryService storyService;

    @GetMapping("newstories/{count}")
    public ResponseEntity<List<Story>> newStories(@PathVariable int count) {
        if (count < 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(storyService.getNewStories(count));
    }
}
