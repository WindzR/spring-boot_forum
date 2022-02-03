package ru.bodins.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bodins.forum.model.Post;
import ru.bodins.forum.model.User;
import ru.bodins.forum.service.PostService;

import java.util.List;

@Controller
public class IndexControl {

    private final PostService posts;

    public IndexControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        List<Post> postList = posts.getAll();
        User user = User.of("Petr Ivanov");
        model.addAttribute("posts", postList);
        model.addAttribute("user", user);
        System.out.println("Все посты на форуме ---> " + postList);
        return "index";
    }
}
