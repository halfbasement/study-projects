package com.sik.springbootdeveloper.controller;

import com.sik.springbootdeveloper.domain.Article;
import com.sik.springbootdeveloper.dto.AddArticleRequest;
import com.sik.springbootdeveloper.dto.ArticleResponse;
import com.sik.springbootdeveloper.dto.UpdateArticleRequest;
import com.sik.springbootdeveloper.service.BlogService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){

        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));

    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){

        blogService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }



    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArtilces(@PathVariable long id, @RequestBody UpdateArticleRequest request){
        Article update = blogService.update(id, request);

        return ResponseEntity.ok().body(update);
    }
}
