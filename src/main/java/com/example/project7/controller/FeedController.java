package com.example.project7.controller;


import com.example.demo.entity.Feed;
import com.example.demo.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feed")
public class FeedController {

    private final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @PostMapping("/create")
    public String createFeed(@RequestBody Feed feed) {
        return feedService.createFeed(feed);
    }

    @GetMapping("/{id}")
    public Feed getFeed(@PathVariable Long id) {
        return feedService.getFeed(id);
    }

    @PutMapping("/update/{id}")
    public String updateFeed(@PathVariable Long id, @RequestBody Feed updatedFeed) {
        return feedService.updateFeed(id, updatedFeed);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFeed(@PathVariable Long id) {
        return feedService.deleteFeed(id);
    }
}

