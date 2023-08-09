package com.example.project7.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ElementCollection
    private List<String> images = new ArrayList<>();

    // Getter, Setter
}
    Repository (FeedRepository.java): 피드 데이터베이스 조작을 위한 리포지토리 인터페이스입니다.
        java
        Copy code
        package com.example.demo.repository;

        import com.example.demo.entity.Feed;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
    Controller (FeedController.java): 피드 관련 기능을 처리하는 컨트롤러 클래스입니다.
        java
        Copy code
        package com.example.demo.controller;

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
    Service (FeedService.java): 비즈니스 로직을 처리하는 서비스 인터페이스입니다.
        java
        Copy code
        package com.example.demo.service;

        import com.example.demo.entity.Feed;

public interface FeedService {
    String createFeed(Feed feed);
    Feed getFeed(Long id);
    String updateFeed(Long id, Feed updatedFeed);
    String deleteFeed(Long id);
}
    Service Implementation (FeedServiceImpl.java): 비즈니스 로직을 구현하는 서비스 클래스입니다.

        java
        Copy code
        package com.example.demo.service.impl;

        import com.example.demo.entity.Feed;
        import com.example.demo.repository.FeedRepository;
        import com.example.demo.service.FeedService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Optional;

@Service
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;

    @Autowired
    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public String createFeed(Feed feed) {
        feedRepository.save(feed);
        return "Feed created!";
    }

    @Override
    public Feed getFeed(Long id) {
        Optional<Feed> feed = feedRepository.findById(id);
        return feed.orElse(null);
    }

    @Override
    public String updateFeed(Long id, Feed updatedFeed) {
        Optional<Feed> existingFeed = feedRepository.findById(id);
        if (existingFeed.isPresent()) {
            Feed feed = existingFeed.get();
            feed.setTitle(updatedFeed.getTitle());
            feed.setContent(updatedFeed.getContent());
            feed.setImages(updatedFeed.getImages());
            feedRepository.save(feed);
            return "Feed updated!";
        }
        return "Feed not found!";
    }

    @Override
    public String deleteFeed(Long


