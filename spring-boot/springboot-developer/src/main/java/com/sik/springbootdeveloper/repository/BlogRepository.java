package com.sik.springbootdeveloper.repository;

import com.sik.springbootdeveloper.domain.Article;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
