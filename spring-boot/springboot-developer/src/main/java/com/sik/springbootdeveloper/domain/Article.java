package com.sik.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content" ,nullable = false)
    private String content;

    @Builder // Id는 오토인크리먼트
    public Article(String title,String content){
        this.title = title;
        this.content = content;
    }


    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }

}
