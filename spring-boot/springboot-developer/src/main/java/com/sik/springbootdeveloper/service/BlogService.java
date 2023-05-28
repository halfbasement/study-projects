package com.sik.springbootdeveloper.service;

import com.sik.springbootdeveloper.domain.Article;
import com.sik.springbootdeveloper.dto.AddArticleRequest;
import com.sik.springbootdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;


    public Article save(AddArticleRequest dto){
        return blogRepository.save(dto.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){//IllegalArgumentException -> 적절하지 못한 인자를 넘겨줬을때 터지는 에러
        return blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found:" + id));
    }
}
