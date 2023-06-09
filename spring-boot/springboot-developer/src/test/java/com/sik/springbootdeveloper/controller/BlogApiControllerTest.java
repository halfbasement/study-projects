package com.sik.springbootdeveloper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sik.springbootdeveloper.domain.Article;
import com.sik.springbootdeveloper.dto.AddArticleRequest;
import com.sik.springbootdeveloper.dto.UpdateArticleRequest;
import com.sik.springbootdeveloper.repository.BlogRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc//MockMvc 생성 & 자동구성 ( mockMvc : mvc테스트 )
@SpringBootTest // @SpringBootApplication 클래스 찾아서 해당 빈을 기반으로 테스트 만듦
class BlogApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper obj;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach
    public void mockMvcSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        blogRepository.deleteAll();
    }

    @DisplayName("addArticle : 블로그 글 추가에 성공한다")
    @Test
    public void addArticle() throws Exception{

        //given
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";
        final AddArticleRequest userRequest = new AddArticleRequest(title,content);

        //직렬화
        final String request = obj.writeValueAsString(userRequest);

        //when
        // 설정 한 내용으로 전송

        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)// application/json
                .content(request));

        //then
        result.andExpect(status().isCreated());

        List<Article> articles = blogRepository.findAll();

        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getContent()).isEqualTo(content);


    }

    @DisplayName("findAllArticles: 블로그 글 목록 조회에 성공한다")
    @Test
    public void findAllArticles() throws Exception{

        //given
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";




        blogRepository.save(Article.builder()
                .content(content)
                .title(title).build());


        //when
        ResultActions resultActions = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));


        //then
        resultActions.andExpect(status().isOk())
                //여러개라 0번쨰가져글
                .andExpect(jsonPath("$[0].content").value(content))
                .andExpect(jsonPath("$[0].title").value(title));

    }


    @DisplayName("findArticle : 블로그 글 조회에 성공한다")
    @Test
    public void findArticle() throws Exception{
        //given
        final String url = "/api/articles/{id}";
        final String title = "title";
        final String content = "content";


        Article savedArticle = blogRepository.save(Article.builder()
                .content(content)
                .title(title)
                .build());

        //when
        final ResultActions resultActions = mockMvc.perform(get(url, savedArticle.getId()));


        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.title").value(title));

    }


    @DisplayName("deleteArticle : 글 삭제에 성공한다")
    @Test
    public void deleteArticle() throws Exception {


        //given
        String url = "/api/articles/{id}";
        String title = "타이틀";
        String content = "내용";


        Article savedArticle = blogRepository.save(new Article(title, content));


        //when
        ResultActions resultActions = mockMvc.perform(delete(url, savedArticle.getId())
        ).andExpect(status().isOk());


        //then
        List<Article> all = blogRepository.findAll();

        assertThat(all).isEmpty();

    }

    @DisplayName("updateArticle : 블로그 글 수정에 성공")
    @Test
    public void updateArticle() throws Exception{

        //given
        String url = "/api/articles/{id}";
        String title = "기본타이틀";
        String content = "기본내용";


        Article savedArticle = blogRepository.save(new Article(title, content));


        final String newTitle ="수정타이틀";
        final String newContent = "수정 내용";


        UpdateArticleRequest updateArticleRequest = new UpdateArticleRequest(newTitle, newContent);

        //when


        ResultActions result = mockMvc.perform(put(url, savedArticle.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(obj.writeValueAsString(updateArticleRequest)));


        //then
        result.andExpect(status().isOk());

        Article findArticle = blogRepository.findById(savedArticle.getId()).get();


        assertThat(findArticle.getTitle()).isEqualTo(newTitle);



    }
}