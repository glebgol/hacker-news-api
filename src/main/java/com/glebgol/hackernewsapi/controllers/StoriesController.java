package com.glebgol.hackernewsapi.controllers;

import com.glebgol.hackernewsapi.model.Story;
import com.glebgol.hackernewsapi.model.StoryForPreview;
import com.glebgol.hackernewsapi.services.StoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class StoriesController {
    private final StoryService storyService;

    @GetMapping("/newstories")
    public ResponseEntity<List<StoryForPreview>> getRecentStories(@RequestParam int count) {
        if (count < 0) {
            log.warn("Bad request: count is less than 0");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(storyService.getRecentStories(count));
    }

    @GetMapping("/story/{id}")
    public ResponseEntity<Story> getStory(@PathVariable int id) {
        Optional<Story> optionalStory = storyService.getStoryById(id);
        if (optionalStory.isEmpty()) {
            log.warn("Story by " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(optionalStory.get());
    }
}
