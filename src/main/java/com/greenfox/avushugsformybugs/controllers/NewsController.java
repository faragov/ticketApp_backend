package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.*;
import com.greenfox.avushugsformybugs.models.entities.User;
import com.greenfox.avushugsformybugs.services.NewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {

  private final NewsService newsService;

  @Autowired
  public NewsController(NewsService newsService) {
    this.newsService = newsService;
  }

  @PostMapping("/admin/news")
  public ResponseEntity postNewNews(@Valid @RequestBody NewNewsDTO newNewsDTO) {

    newsService.saveNewNews(newNewsDTO);

    return new ResponseEntity(new SuccessMessage("Successfully posted"), HttpStatus.CREATED);
  }

  @DeleteMapping("/admin/news/{id}")
  public ResponseEntity deleteNewsById(@PathVariable Long id) {

    newsService.deleteNews(id);

    return new ResponseEntity(new SuccessMessage("Successfully deleted"), HttpStatus.OK);
  }

  @PutMapping("/admin/news/{id}")
  public ResponseEntity editNews(@PathVariable Long id, @RequestBody EditNewsDTO editNewsDTO) {

    newsService.editNews(id, editNewsDTO);

    return new ResponseEntity(new SuccessMessage("Successfully changed"), HttpStatus.CREATED);
  }

  @GetMapping("/topnews")
  public ResponseEntity getTopThreeNews() {

    List<TopNewsDTO> responseList = newsService.convertTopThree();
    return ResponseEntity.status(200).body(responseList);
  }

  @PutMapping("/news/{id}/increaseVisitorCount")
  public ResponseEntity increaseVisitorCount(@PathVariable Long id) {

    newsService.increaseCount(id);

    return new ResponseEntity(new SuccessMessage("Successfully changed"), HttpStatus.CREATED);
  }

  @PostMapping("/news")
  public ResponseEntity makeNewsAsUser(@AuthenticationPrincipal User loginedUser,
                                       @Valid @RequestBody UserNewsDTO userNewsDTO) {

    newsService.saveUserNews(loginedUser, userNewsDTO);

    return new ResponseEntity(new SuccessMessage("Successfully posted"), HttpStatus.CREATED);
  }
}
