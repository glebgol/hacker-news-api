package com.glebgol.hackernewsapi.controllers;

import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.model.StoryForPreview;
import com.glebgol.hackernewsapi.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class StoriesController {
    private final StoryService storyService;

    @GetMapping("/newstories")
    public ResponseEntity<List<StoryForPreview>> getNewStories(@RequestParam int count) {
        if (count < 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(storyService.getNewStories(count));
    }

    @GetMapping("/story/{id}")
    public ResponseEntity<Story> getStory(@PathVariable int id) {
        Optional<Story> optionalStory = storyService.getStoryById(id);
        if (optionalStory.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalStory.get());
    }
}
