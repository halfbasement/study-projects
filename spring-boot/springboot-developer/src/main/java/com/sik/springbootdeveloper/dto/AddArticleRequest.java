package com.sik.springbootdeveloper.dto;

import com.sik.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
                .content(this.content)
                .title(this.title).build();
    }
}
