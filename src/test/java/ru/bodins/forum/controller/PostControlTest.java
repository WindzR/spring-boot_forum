package ru.bodins.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ru.bodins.forum.Main;
import ru.bodins.forum.model.Post;
import ru.bodins.forum.service.PostService;

import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
    public void updatePost() throws Exception {
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
}