package ru.bodins.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import ru.bodins.forum.Main;
import ru.bodins.forum.dao.UserRepository;
import ru.bodins.forum.model.User;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class RegControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository users;

    @Test
    public void returnRegPage() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

    @Test
    public void whenRegisterNewUser() throws Exception {
        Mockito.when(users.findDistinctByUsernameLike(Mockito.anyString())).thenReturn(null);
        this.mockMvc.perform(post("/reg")
                        .param("username", "test")
                        .param("password", "123"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(users).save(argument.capture());
        System.out.println(argument.getAllValues());
        assertThat(argument.getValue().getUsername(), is("test"));
        assertTrue(new BCryptPasswordEncoder().matches("123", argument.getValue().getPassword()));
    }

    @Test
    public void whenTryRegisterExistUser() throws Exception {
        Mockito.when(users.findDistinctByUsernameLike(Mockito.anyString())).thenReturn(User.of("root"));
        this.mockMvc.perform(post("/reg")
                        .param("username", "root")
                        .param("password", "123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }
}