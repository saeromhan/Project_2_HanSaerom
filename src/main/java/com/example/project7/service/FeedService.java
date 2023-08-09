package com.example.project7.service;

import com.example.project7.entity.Feed;

public interface FeedService {
    String createFeed(Feed feed);
    Feed getFeed(Long id);
    String updateFeed(Long id, Feed updatedFeed);
    String deleteFeed(Long id);
}