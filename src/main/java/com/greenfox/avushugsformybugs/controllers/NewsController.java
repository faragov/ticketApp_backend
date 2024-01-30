package com.greenfox.avushugsformybugs.controllers;

import com.greenfox.avushugsformybugs.dtos.NewNewsDTO;
import com.greenfox.avushugsformybugs.dtos.SuccessMessage;
import com.greenfox.avushugsformybugs.models.entities.News;
import com.greenfox.avushugsformybugs.services.NewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {

  private final NewsService newsService;

  @Autowired
  public NewsController(NewsService newsService) {
    this.newsService = newsService;
  }

  @PostMapping("/admin/news")
  public ResponseEntity postNewNews(@Valid @RequestBody NewNewsDTO newNewsDTO) {

    News newNews = newsService.convertDtoToNews(newNewsDTO);
    newsService.saveNewNews(newNews);

    return new ResponseEntity(new SuccessMessage("Successfully posted"), HttpStatus.CREATED);
  }

  @DeleteMapping("/admin/news/{id}")
  public ResponseEntity deleteNewsById(@PathVariable Long id) {

    newsService.deleteNews(id);

    return new ResponseEntity(new SuccessMessage("Successfully deleted"), HttpStatus.OK);
  }
}
