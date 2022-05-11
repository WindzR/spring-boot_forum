package ru.bodins.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ru.bodins.forum.Main;
import ru.bodins.forum.model.Author;
import ru.bodins.forum.model.Comment;
import ru.bodins.forum.model.Post;
import ru.bodins.forum.service.PostService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService service;

    @Test
    @WithMockUser
    public void showCreatePage() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/create"));
    }

    @Test
    @WithMockUser
    public void whenUpdatePost() throws Exception {
        Post post = Post.of("name", "description", new Date());
        Mockito.when(service.findPostById(Mockito.anyInt())).thenReturn(post);
        this.mockMvc.perform(get("/update?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/update"));
    }

    @Test
    @WithMockUser
    public void showPost() throws Exception {
        this.mockMvc.perform(get("/view?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/post"));
    }

    @Test
    @WithMockUser
    public void whenSaveNewPost() throws Exception {
        this.mockMvc.perform(post("/save")
                .param("name", "Servlet API")
                .param("description", "Обсуждение сервлетов"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(service).savePost(argument.capture());
        assertThat(argument.getValue().getName(), is("Servlet API"));
        assertThat(argument.getValue().getDescription(), is("Обсуждение сервлетов"));
    }

    @Test
    @WithMockUser
    public void whenSaveNewComment() throws Exception {
        Author author = Author.of(1, "Ivan");
        Post post = Post.of("Servlet API", "Обсуждение сервлетов", new Date());
        Mockito.when(service.findAuthorById(Mockito.anyInt())).thenReturn(author);
        Mockito.when(service.findPostById(Mockito.anyInt())).thenReturn(post);
        this.mockMvc.perform(post("/save/comment")
                .param("post_id", "1")
                .param("desc", "Сервлеты - отстой! SpringBoot - forever!"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/view?id=1"));
        ArgumentCaptor<Comment> argument = ArgumentCaptor.forClass(Comment.class);
        verify(service).saveComment(argument.capture());
        assertThat(argument.getValue().getComment(), is("Сервлеты - отстой! SpringBoot - forever!"));
        assertThat(argument.getValue().getAuthor(), is(author));
    }
}