package com.sik.springbootdeveloper.controller;

import com.sik.springbootdeveloper.domain.Article;
import com.sik.springbootdeveloper.dto.AddArticleRequest;
import com.sik.springbootdeveloper.dto.ArticleResponse;
import com.sik.springbootdeveloper.service.BlogService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest requestDto){
        Article savedDto = blogService.save(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(articles);
    }
}
